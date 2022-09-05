package com.app.mvvmdemoapp.domain.use_case

import com.app.mvvmdemoapp.common.Resource
import com.app.mvvmdemoapp.data.remote.dto.toLoginUser
import com.app.mvvmdemoapp.domain.model.LoginUser
import com.app.mvvmdemoapp.domain.repository.UserRepository
import com.google.gson.JsonObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUserUseCase @Inject constructor(
    private val repository: UserRepository
) {
    operator fun invoke(name: String, password: String): Flow<Resource<LoginUser>> = flow {
        try {
            emit(Resource.Loading<LoginUser>())
            val jsonObject = JsonObject()
            jsonObject.addProperty("login", name)
            jsonObject.addProperty("password", password)
            val user = repository.userLogin(jsonObject).toLoginUser()
            emit(Resource.Success<LoginUser>(user))
        } catch(e: HttpException) {
            emit(Resource.Error<LoginUser>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<LoginUser>("Couldn't reach server. Check your internet connection."))
        }
    }
}