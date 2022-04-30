package com.example.mmau.domain.model.bloodmodel




data class RequestBloodModel(
    val `data`: List<Data>
) {

    data class Data(

        val blood_group: String, // A+
        val date: String, // 2022-04-30T04:23:30.859587Z
        val id: Int, // 25
        val location: String, // halol
        val mobile_no: String, // 75865445544
        val name: String, // test test
        val units: Int // 200
    )
}