package com.wildlifespotter.data.repository

import com.wildlifespotter.data.local.dao.UserDao
import com.wildlifespotter.data.local.entity.UserEntity
import com.wildlifespotter.domain.model.User
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getUserById(userId: Long): UserEntity? {
        return userDao.getUserById(userId)
    }

    fun insertUser(user: UserEntity) {
        userDao.insertUser(user)
    }

    fun getLeaderboard(): List<User> {
        // Return empty list for now - can be populated from database later
        return emptyList()
    }
}