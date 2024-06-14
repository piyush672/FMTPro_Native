package com.example.fmtpro

import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.fmtpro.models.loadingState.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(private val rootRepository:RootRepository):ViewModel() {

    private var _isLoggedIn = MutableStateFlow<LoadingState<Boolean>>(LoadingState.Loading())
    val isLoggedIn: StateFlow<LoadingState<Boolean>> = _isLoggedIn

    init{
        fetchIsLoggedIn()
    }

    private fun fetchIsLoggedIn(){
        viewModelScope.launch {
            rootRepository.isLoggedIn().collect{
                println("value from db $it")
                _isLoggedIn.value=it
            }
        }
    }
}