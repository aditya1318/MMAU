package com.example.mmau.data.remote

import com.example.mmau.domain.model.usermodel.UserLoginDetail
import com.example.mmau.domain.model.usermodel.UserLoginInfo
import com.example.mmau.domain.model.usermodel.UserRegisterInfo
import com.example.mmau.domain.model.usermodel.UserRegisterdetail
import retrofit2.http.GET
import retrofit2.http.POST

interface MmauApi {

    @POST("/bloodapi/loginUser/")
    suspend fun loginUser(userLoginDetail: UserLoginDetail) :UserLoginInfo

    @POST("/bloodapi/registerUser/")
    suspend fun registerUser(userRegisterdetail: UserRegisterdetail) : UserRegisterInfo



    companion object {

        const val BASE_URL = "http://10.10.2.0.42:8000"
    }
}