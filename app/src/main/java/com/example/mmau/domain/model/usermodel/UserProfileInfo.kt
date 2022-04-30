package com.example.mmau.domain.model.usermodel





data class UserProfileInfo(
    val `data`: Data
) {

    data class Data(
        val address: String, // haskpifnizfnhSbnjaniaisagni
        val age: Int, // 20

        val blood_donated_counter: Int, // 0

        val blood_group: String, // B+
        val id: Int, // 4

        val last_blood_donated: Any?, // null
        val name: String, // mirage darji

        val reward_point: Any? // null
    )
}