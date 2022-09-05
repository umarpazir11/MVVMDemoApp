package com.app.mvvmdemoapp.di

import com.app.mvvmdemoapp.common.Constants
import com.app.mvvmdemoapp.data.remote.MvvmDemoApi
import com.app.mvvmdemoapp.data.repository.UserRepositoryImpl
import com.app.mvvmdemoapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMvvmDemoApi(): MvvmDemoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MvvmDemoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: MvvmDemoApi): UserRepository {
        return UserRepositoryImpl(api)
    }
}