package com.example.mmau.domain.repository

import com.example.mmau.domain.model.usermodel.UserLoginDetail
import com.example.mmau.domain.model.usermodel.UserLoginInfo
import com.example.mmau.util.Resource

interface UserLoginRepository {
    suspend fun UserLogin(userLoginDetail: UserLoginDetail):UserLoginInfo
}