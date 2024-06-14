package com.example.fmtpro.roomDB.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.fmtpro.roomDB.database.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<User>>

    @Insert
    fun insertUser(user: User)

    // You can define other CRUD operations here
}