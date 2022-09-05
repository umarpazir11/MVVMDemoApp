package com.app.mvvmdemoapp.domain.repository

import com.app.mvvmdemoapp.data.remote.dto.LoginUserDto
import com.app.mvvmdemoapp.data.remote.dto.RegisterUserDto
import com.google.gson.JsonObject
import retrofit2.http.POST

interface UserRepository {

    suspend fun userLogin(jsonObject: JsonObject): LoginUserDto

    suspend fun userRegister(): RegisterUserDto

}