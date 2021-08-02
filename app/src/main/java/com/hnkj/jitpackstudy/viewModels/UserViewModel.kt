package com.hnkj.jitpackstudy.viewModels

import androidx.lifecycle.*
import com.hnkj.jitpackstudy.data.User
import com.hnkj.jitpackstudy.data.UserRepository
import kotlinx.coroutines.launch

/**
 * @author: zhuw
 * Created by zhuwang 2021-08-02-星期一-上午11:16
 * Email zhuwang999@foxmail.com
 */
class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val allUsers: LiveData<List<User>> = userRepository.allUsers().asLiveData()

    fun insertUser(user: User) = viewModelScope.launch {
        userRepository.insert(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch {
        userRepository.deleteUser(user)
    }

    fun deleteAll() = viewModelScope.launch {
        userRepository.deleteAll()
    }
}

class UserViewModelFactory(private val repository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}