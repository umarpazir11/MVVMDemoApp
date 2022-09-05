package com.app.mvvmdemoapp.domain.model

data class LoginUser(
    val accountType: String,
    val created: Long,
    val email: String,
    val name: String,
    val oAuthIdentities: String?,
    val ownerId: String,
    val usertoken: String,
    val userStatus: String
)
