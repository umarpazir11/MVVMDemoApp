package com.app.mvvmdemoapp.presentation.user_login

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.app.mvvmdemoapp.common.Resource
import com.app.mvvmdemoapp.domain.use_case.LoginUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val userLogin: LoginUserUseCase
): ViewModel() {

    private val _state = mutableStateOf(LoginUserState())
    val state: State<LoginUserState> = _state

    init {
        //userLogin()
    }

    private fun userLogin() {
        userLogin("umarrr@gmail.com", "12345678").onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = LoginUserState(user = result.data)
                    Log.i("result.data", result.data.toString())
                }
                is Resource.Error -> {
                    _state.value = LoginUserState(
                        error = result.message ?: "An unexpected error occured"
                    )
                    Log.i("result.message", result.message.toString())

                }
                is Resource.Loading -> {
                    _state.value = LoginUserState(isLoading = true)
                    Log.i("Loading", "Result")
                }
            }
        }.launchIn(viewModelScope)
    }
}