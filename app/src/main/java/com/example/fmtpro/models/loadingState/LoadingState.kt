package com.example.fmtpro.models.loadingState

sealed class LoadingState<T>(val content: T? = null,val loading:Boolean) {
    class Loading<T>() : LoadingState<T>(loading=true)
    data class Success<T>(val data:T) : LoadingState<T>(data,false)
    data class Error<T>(val error: Throwable) : LoadingState<T>(loading=false)
}
