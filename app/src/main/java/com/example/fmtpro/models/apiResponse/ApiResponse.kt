package com.example.fmtpro.models.apiResponse

data class ApiResponse<T>(
    val status: Boolean,
    val data: T?,
    val message: String?,
    val errorCode: Int?
)
