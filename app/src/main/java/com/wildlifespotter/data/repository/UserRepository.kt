package com.wildlifespotter.data.repository

import com.wildlifespotter.data.local.dao.UserDao
import com.wildlifespotter.data.local.entity.UserEntity
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    suspend fun getUserById(userId: String): UserEntity? {
        return userDao.getUserById(userId)
    }

    suspend fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: UserEntity) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(userId: String) {
        userDao.deleteUser(userId)
    }
}