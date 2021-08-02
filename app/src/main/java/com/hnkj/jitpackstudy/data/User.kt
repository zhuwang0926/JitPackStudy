package com.hnkj.jitpackstudy.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author: zhuw
 * Created by zhuwang 2021-08-02-星期一-上午10:29
 * Email zhuwang999@foxmail.com
 */
@Entity
data class User(
    val name: String,
    val description: String,
){
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "uid") var userId: Int = 0
}
