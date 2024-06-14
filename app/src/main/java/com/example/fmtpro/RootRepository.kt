package com.example.fmtpro

import com.example.fmtpro.models.loadingState.LoadingState
import com.example.fmtpro.roomDB.dao.UserDao
import com.example.fmtpro.roomDB.database.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RootRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun getUserFromDB(): Flow<LoadingState<User>> = flow{
        try {
            emit(LoadingState.Loading())
            val user = userDao.getAllUsers().firstOrNull()
            if (user != null) {
                delay(2000)
                emit(LoadingState.Success(user[0]))
            } else {
                delay(2000)
                emit(LoadingState.Error(Exception("No user found")))
            }
        } catch (e: Exception) {
            emit(LoadingState.Error(e))
        }
    }

    fun isLoggedIn():Flow<LoadingState<Boolean>> = flow{
        emit(LoadingState.Loading())
        userDao.getAllUsers().collect { users ->
            if (users.isNotEmpty()) {
                emit(LoadingState.Success(true))
            } else {
                emit(LoadingState.Success(false))
            }
        }
    }.catch {e->
        emit(LoadingState.Error(e))
    }
}