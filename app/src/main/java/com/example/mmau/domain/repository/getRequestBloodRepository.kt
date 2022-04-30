package com.example.mmau.domain.repository

import com.example.mmau.domain.model.bloodmodel.RequestBloodModel

interface getRequestBloodRepository {
    suspend fun getAllRequestBlood():RequestBloodModel
}