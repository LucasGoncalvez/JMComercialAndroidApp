package com.example.jmcomercialapp.b_viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jmcomercialapp.c_data.login.clases.UserDetail

class LoginViewModel: ViewModel() {

    private val _currentUser = MutableLiveData<UserDetail>()
    val currentUser: LiveData<UserDetail>
        get() = _currentUser

    fun setCurrentUser(user: UserDetail) {
        _currentUser.value = user
    }

}