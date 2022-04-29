package com.example.mmau.domain.repository

import com.example.mmau.domain.model.usermodel.UserRegisterInfo
import com.example.mmau.domain.model.usermodel.UserRegisterdetail
import com.example.mmau.util.Resource

interface UserRegisterRepository {
    suspend fun userRegister(userRegisterdetail: UserRegisterdetail):UserRegisterInfo
}