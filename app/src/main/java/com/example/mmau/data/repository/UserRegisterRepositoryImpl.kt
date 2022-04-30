package com.example.mmau.data.repository

import com.example.mmau.data.remote.MmauApi
import com.example.mmau.domain.model.usermodel.UserRegisterInfo
import com.example.mmau.domain.model.usermodel.UserRegisterdetail
import com.example.mmau.domain.repository.UserRegisterRepository
import com.example.mmau.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRegisterRepositoryImpl @Inject constructor(
    private val api: MmauApi) : UserRegisterRepository {

    override suspend fun userRegister(userRegisterdetail: UserRegisterdetail): UserRegisterInfo {
          return api.registerUser(userRegisterdetail)
    }


}