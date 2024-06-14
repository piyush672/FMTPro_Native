package com.example.fmtpro.models.user

data class Token(
    val ml_user: MlUser,
    val token: String,
    val user_profile: UserProfile
)