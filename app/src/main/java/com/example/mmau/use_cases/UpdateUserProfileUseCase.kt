package com.example.mmau.use_cases

import com.example.mmau.domain.model.usermodel.UserProfileInfo
import com.example.mmau.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UpdateUserProfileUseCase (
    private val userProfileUseCase: UpdateUserProfileUseCase
) {

    operator fun invoke(user_id:String,userProfileInfo: UserProfileInfo): Flow<Resource<Boolean>> =  flow{
        try {
            val data = userProfileUseCase.invoke(user_id,userProfileInfo)
            emit(Resource.Success(true))
        }catch (e:Exception){
            e.localizedMessage?.let { Resource.Error<Boolean>(it) }?.let { emit(it) }
        }
    }
}