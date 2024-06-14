package com.example.fmtpro.roomDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.fmtpro.roomDB.dao.UserDao
import com.example.fmtpro.roomDB.database.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}