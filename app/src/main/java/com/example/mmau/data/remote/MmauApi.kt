package com.example.mmau.data.remote

import com.example.mmau.domain.model.bloodmodel.RequestBloodModel
import com.example.mmau.domain.model.usermodel.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface MmauApi {

    @POST("/bloodapi/loginUser/")
    suspend fun loginUser(@Body userLoginDetail: UserLoginDetail) :UserLoginInfo

    @POST("/bloodapi/registerUser/")
    suspend fun registerUser(@Body userRegisterdetail: UserRegisterdetail) : UserRegisterInfo

    @GET("/bloodapi/userProfile/")
    suspend fun getUserProfile():   UserProfileInfo

    @PUT("/bloodapi/userProfile/")
    suspend fun updateUserProfile(@Body userProfileInfo: UserProfileInfo,@Body user_id:String)

    @GET("/bloodapi/getBloodDetails/")
    suspend fun getAllBloodRequest():RequestBloodModel



    companion object {

        const val BASE_URL = "http://10.10.2.0.42:8000"
    }
}