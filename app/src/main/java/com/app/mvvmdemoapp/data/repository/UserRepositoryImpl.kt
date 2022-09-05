package com.app.mvvmdemoapp.data.repository

import com.app.mvvmdemoapp.data.remote.MvvmDemoApi
import com.app.mvvmdemoapp.data.remote.dto.LoginUserDto
import com.app.mvvmdemoapp.data.remote.dto.RegisterUserDto
import com.app.mvvmdemoapp.domain.repository.UserRepository
import com.google.gson.JsonObject
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: MvvmDemoApi
): UserRepository {
    override suspend fun userLogin(jsonObject: JsonObject): LoginUserDto {
        return api.loginUser(jsonObject)
    }

    override suspend fun userRegister(): RegisterUserDto {
        return api.registerUser()
    }

}