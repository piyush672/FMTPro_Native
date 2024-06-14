package com.example.fmtpro.unAuthenticated.unauthenticatedViewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fmtpro.models.loadingState.LoadingState
import com.example.fmtpro.models.user.UserApiResponse
import com.example.fmtpro.roomDB.database.User
import com.example.fmtpro.unAuthenticated.repository.UserValidationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ValidateUserBody(
    val otp:String?=null,
    val mobile_number:String
)

object UserObj{
    fun getUserObj(userApiResponse: UserApiResponse): User {
        return User(
            token=userApiResponse.token!!.token,
            name=userApiResponse.token.user_profile.name,
            designation=userApiResponse.token.user_profile.user_role_id,
            reportsTo=userApiResponse.token.ml_user.reportsTo.name
        )
    }
}

@HiltViewModel
class UnauthenticatedViewmodel @Inject constructor(private val repository: UserValidationRepository):ViewModel() {
    val mobile= mutableStateOf("")
    val otp= mutableStateOf("")
    val isValidated= mutableStateOf(false)
    val isLoading= mutableStateOf(false)

    fun onChangeMobile(value:String){
        mobile.value=value
    }

    fun onChangeOTP(value:String){
       otp.value=value
    }

    fun onGetOtp(){
      viewModelScope.launch {
          repository.getOtp(ValidateUserBody(mobile_number = mobile.value)).collect{
              when(it){
                  is LoadingState.Loading -> isLoading.value=true
                  is LoadingState.Success -> {
                      isValidated.value = true
                      isLoading.value =false
                  }
                  is LoadingState.Error ->{
                      isValidated.value = false
                      isLoading.value =false
                  }
              }
          }
      }
    }

    fun validateOtp(){
        viewModelScope.launch {
            repository.validateOtp(ValidateUserBody(mobile_number = mobile.value, otp = otp.value)).collect{
                when(it){
                    is LoadingState.Loading -> isLoading.value=true
                    is LoadingState.Success -> {
                        val user=UserObj.getUserObj(it.data!!)
                        repository.insertUserInDb(user)
                        isLoading.value =false
                    }
                    is LoadingState.Error ->{
                        isLoading.value =false
                        isLoading.value =false
                    }
                }
            }
        }
    }
}