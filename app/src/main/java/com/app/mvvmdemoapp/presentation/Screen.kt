package com.app.mvvmdemoapp.presentation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    //object CoinDetailScreen: Screen("coin_detail_screen")
}
