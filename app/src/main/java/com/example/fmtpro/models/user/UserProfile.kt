package com.example.fmtpro.models.user

data class UserProfile(
    val address: String,
    val agent_code: Int,
    val email: String,
    val mobile_number: Int,
    val name: String,
    val user_role_id: Int
)