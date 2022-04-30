package com.example.mmau.data.repository

import com.example.mmau.data.remote.MmauApi
import com.example.mmau.domain.model.bloodmodel.RequestBloodModel
import com.example.mmau.domain.repository.getRequestBloodRepository
import javax.inject.Inject

class getRequestBloodRepositoryImpl @Inject constructor(
    private val api: MmauApi
) :getRequestBloodRepository{
    override suspend fun getAllRequestBlood(): RequestBloodModel {
        return api.getAllBloodRequest()
    }
}