package com.hnkj.jitpackstudy.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * @author: zhuw
 * Created by zhuwang 2021-08-02-星期一-上午10:39
 * Email zhuwang999@foxmail.com
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM User ORDER BY name")
    fun getUsers():Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Query("DELETE FROM USER")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteUser(user: User)
}