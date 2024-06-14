package com.example.fmtpro.api

import com.example.fmtpro.models.apiResponse.ApiResponse
import com.example.fmtpro.models.user.UserApiResponse
import com.example.fmtpro.unAuthenticated.unauthenticatedViewmodel.ValidateUserBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthenticationApi {
    @POST("/auth/getOtp/ml")
    suspend fun getOtp(@Body request: ValidateUserBody): Response<ApiResponse<String>>

    @POST("/auth/validate_otp_get_token")
    suspend fun validateOtp(@Body request: ValidateUserBody): Response<ApiResponse<UserApiResponse>>
}