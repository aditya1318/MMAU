package com.example.mmau.use_cases

import com.example.mmau.domain.model.bloodmodel.RequestBloodModel
import com.example.mmau.domain.repository.getRequestBloodRepository
import com.example.mmau.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAllRequestBloodUseCase @Inject constructor(
    private val getRequestBloodRepository: getRequestBloodRepository
) {

    operator fun invoke(): Flow<Resource<RequestBloodModel>> = flow{
        try {
val data = getRequestBloodRepository.getAllRequestBlood()
            emit(Resource.Success<RequestBloodModel>(data))
        }catch (e:Exception){
            e.localizedMessage?.let { Resource.Error<RequestBloodModel>(it) }?.let { emit(it) }
        }
    }

}