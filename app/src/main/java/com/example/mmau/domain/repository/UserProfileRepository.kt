package com.example.mmau.domain.repository

import com.example.mmau.domain.model.usermodel.UserProfileInfo

interface UserProfileRepository  {
    suspend fun GetUserProfile():UserProfileInfo

    suspend fun UpdateUserProfile(user_id:String,userProfileInfo: UserProfileInfo)
}