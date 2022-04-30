package com.example.mmau.use_cases

import com.example.mmau.domain.model.usermodel.UserRegisterInfo
import com.example.mmau.domain.model.usermodel.UserRegisterdetail
import com.example.mmau.domain.repository.UserRegisterRepository
import com.example.mmau.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRegisterUseCase @Inject constructor(
    private val repository: UserRegisterRepository
) {
    operator fun invoke(userRegisterdetail: UserRegisterdetail) : Flow<Resource<UserRegisterInfo>> = flow {
        try {
            val data = repository.userRegister(userRegisterdetail)
            emit(Resource.Success<UserRegisterInfo>(data))
        }catch (e:Exception){
            e.localizedMessage?.let { Resource.Error<UserRegisterInfo>(it) }?.let { emit(it) }
        }
    }
}