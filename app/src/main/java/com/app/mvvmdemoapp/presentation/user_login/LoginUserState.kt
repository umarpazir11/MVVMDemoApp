package com.app.mvvmdemoapp.presentation.user_login

import com.app.mvvmdemoapp.domain.model.LoginUser

data class LoginUserState(
    val isLoading: Boolean = false,
    val user: LoginUser? = null,
    val error: String = ""
)
