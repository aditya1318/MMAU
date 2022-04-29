package com.example.mmau.data.repository

import com.example.mmau.data.remote.MmauApi
import com.example.mmau.domain.model.usermodel.UserLoginDetail
import com.example.mmau.domain.model.usermodel.UserLoginInfo
import com.example.mmau.domain.repository.UserLoginRepository
import com.example.mmau.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserLoginRepositoryImpl @Inject constructor(
    private val api: MmauApi
) :UserLoginRepository {
    override suspend fun UserLogin(userLoginDetail: UserLoginDetail): UserLoginInfo {
return api.loginUser(userLoginDetail)
    }

}