package com.example.fmtpro.roomDB.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.fmtpro.models.user.UserApiResponse

@Entity(tableName = "User")
data class User(
    @PrimaryKey
    val token:String,
    val name:String,
    val designation:Int,
    val reportsTo:String
)