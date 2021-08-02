package com.hnkj.jitpackstudy.data

import kotlinx.coroutines.flow.Flow

/**
 * @author: zhuw
 * Created by zhuwang 2021-08-02-星期一-上午11:07
 * Email zhuwang999@foxmail.com
 */
class UserRepository(private val userDao: UserDao) {

    fun allUsers(): Flow<List<User>> = userDao.getUsers()

    suspend fun insert(user: User) {
        userDao.insertUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAll() {
        userDao.deleteAll()
    }

}