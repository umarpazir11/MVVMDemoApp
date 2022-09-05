package com.app.mvvmdemoapp.data.remote

import com.app.mvvmdemoapp.data.remote.dto.LoginUserDto
import com.app.mvvmdemoapp.data.remote.dto.RegisterUserDto
import com.google.gson.JsonObject
import retrofit2.http.Body
import retrofit2.http.POST

interface MvvmDemoApi {

     @POST("users/login")
     suspend fun loginUser(@Body jsonObject: JsonObject) : LoginUserDto

     @POST("users/register")
     suspend fun registerUser() : RegisterUserDto
}