package com.example.mmau.use_cases

import com.example.mmau.domain.model.usermodel.UserLoginDetail
import com.example.mmau.domain.model.usermodel.UserLoginInfo
import com.example.mmau.domain.repository.UserLoginRepository
import com.example.mmau.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import javax.inject.Inject

class UserLoginUseCase @Inject constructor(private  val repository: UserLoginRepository) {

    operator fun invoke (userLoginDetail: UserLoginDetail):Flow<Resource<UserLoginInfo>> = flow {

        try {
            val data=repository.UserLogin(userLoginDetail)
         emit(Resource.Success<UserLoginInfo>(data))
        }catch (exception:Exception){
            exception.localizedMessage?.let { Resource.Error<UserLoginInfo>(it) }?.let { emit(it) }
        }
    }

}