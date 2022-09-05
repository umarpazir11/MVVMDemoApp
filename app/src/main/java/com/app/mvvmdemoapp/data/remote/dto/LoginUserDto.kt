package com.app.mvvmdemoapp.data.remote.dto

import com.app.mvvmdemoapp.domain.model.LoginUser
import com.google.gson.annotations.SerializedName

data class LoginUserDto(
    val ___class: String,
    val accountType: String,
    val blUserLocale: String,
    val created: Long,
    val email: String,
    val lastLogin: Long,
    val name: String,
    val oAuthIdentities: String,
    val objectId: String,
    val ownerId: String,
    val socialAccount: String,
    val updated: Long,
    @SerializedName("user-token")
    val usertoken: String,
    val userStatus: String
)

fun LoginUserDto.toLoginUser(): LoginUser {
    return LoginUser(
        accountType = accountType,
        created = created,
        email = email,
        name = name,
        oAuthIdentities = oAuthIdentities,
        ownerId = ownerId,
        usertoken = usertoken,
        userStatus = userStatus
    )
}