package com.example.mmau.di

import com.example.mmau.data.repository.UserLoginRepositoryImpl
import com.example.mmau.data.repository.UserRegisterRepositoryImpl
import com.example.mmau.domain.repository.UserLoginRepository
import com.example.mmau.domain.repository.UserRegisterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract  class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUserLoginRepository(
        userLoginRepositoryImpl:  UserLoginRepositoryImpl
    ): UserLoginRepository

    @Binds
    @Singleton
    abstract fun bindUserRegisterRepository(
        userRegisterRepositoryImpl:  UserRegisterRepositoryImpl
    ): UserRegisterRepository
}