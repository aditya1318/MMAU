package com.example.mmau.use_cases

import com.example.mmau.domain.model.usermodel.UserProfileInfo
import com.example.mmau.domain.repository.UserProfileRepository
import com.example.mmau.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserProfileUseCase @Inject constructor(
    private val repository: UserProfileRepository
){
    operator fun invoke(): Flow<Resource<UserProfileInfo>> = flow {
        try {
            val data = repository.GetUserProfile()
            emit(Resource.Success<UserProfileInfo>(data))
        }catch (e:Exception){
            e.localizedMessage?.let { Resource.Error<UserProfileInfo>(it) }?.let { emit(it) }
        }
    }

}