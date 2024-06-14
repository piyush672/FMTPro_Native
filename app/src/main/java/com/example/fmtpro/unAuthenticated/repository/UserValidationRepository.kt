package com.example.fmtpro.unAuthenticated.repository

import com.example.fmtpro.api.AuthenticationApi
import com.example.fmtpro.models.apiResponse.ApiResponse
import com.example.fmtpro.models.loadingState.LoadingState
import com.example.fmtpro.models.user.UserApiResponse
import com.example.fmtpro.roomDB.dao.UserDao
import com.example.fmtpro.roomDB.database.User
import com.example.fmtpro.unAuthenticated.unauthenticatedViewmodel.ValidateUserBody
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class UserValidationRepository @Inject constructor(private val api: AuthenticationApi,private val db: UserDao) {

    fun getOtp(body: ValidateUserBody): Flow<LoadingState<Boolean>> = flow{
        try{
            emit(LoadingState.Loading())
            val response=api.getOtp(body).body()
            if (response != null) {
                if(!response.status){
                    throw Error(response.message)
                }else{
                   emit(LoadingState.Success(true))
                }
            }
        }catch (error:Exception){
            emit(LoadingState.Error(error))
        }
    }

    fun validateOtp(body: ValidateUserBody): Flow<LoadingState<UserApiResponse?>> = flow{
            println("i am called validate otp $body")
            emit(LoadingState.Loading())
            val response=api.validateOtp(body).body()
            println("response is*23 $response")
            if (response != null) {
                if(!response.status){
                    throw Error(response.message)
                }else{
                  emit(LoadingState.Success(response.data))
                }
            }
    }.catch {error ->
        println("error is val otp ${error.message}")
        emit(LoadingState.Error(error))
    }

    suspend fun insertUserInDb(user:User){
        withContext(Dispatchers.IO) {
            db.insertUser(user)
        }
    }
}