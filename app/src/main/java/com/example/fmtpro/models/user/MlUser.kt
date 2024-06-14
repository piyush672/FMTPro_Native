package com.example.fmtpro.models.user

data class MlUser(
    val _id: Int,
    val designation: Int,
    val employee_id: String,
    val name: String,
    val reportsTo: ReportsTo
)