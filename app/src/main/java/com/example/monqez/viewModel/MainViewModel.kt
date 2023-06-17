package com.example.monqez.viewModel

import androidx.lifecycle.*
import com.example.monqez.pojo.User
import com.example.monqez.pojo.UserReq
import com.example.monqez.repository.UserRepository
import kotlinx.coroutines.launch

class MainViewModel(private val userRepository: UserRepository): ViewModel() {
    private val _user: MutableLiveData<User?> = MutableLiveData<User?>()
    val user:LiveData<User?>
    get() = _user

    fun getUser(data: UserReq) {
        viewModelScope.launch {
            _user.postValue(userRepository.getUser(data))
        }
    }
    fun clearUser(){
        _user.postValue(null)
    }
    class MainViewModelFactory(private val userRepository: UserRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return MainViewModel(userRepository) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}