package com.hnkj.jitpackstudy

import android.app.Application
import com.hnkj.jitpackstudy.data.AppDatabase
import com.hnkj.jitpackstudy.data.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * @author: zhuw
 * Created by zhuwang 2021-08-02-星期一-下午2:01
 * Email zhuwang999@foxmail.com
 */
class MyApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this,applicationScope) }
    val repository by lazy { UserRepository(database.userDao()) }

}