package com.example.mmau.data.repository

import com.example.mmau.data.remote.MmauApi
import com.example.mmau.domain.model.usermodel.UserProfileInfo
import com.example.mmau.domain.repository.UserProfileRepository
import com.example.mmau.domain.repository.UserRegisterRepository
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    private val api: MmauApi
):UserProfileRepository {
    override suspend fun GetUserProfile(): UserProfileInfo {
        return api.getUserProfile()
    }

    override suspend fun UpdateUserProfile(user_id: String,userProfileInfo: UserProfileInfo) {
return api.updateUserProfile(user_id = user_id, userProfileInfo = userProfileInfo)
    }

}