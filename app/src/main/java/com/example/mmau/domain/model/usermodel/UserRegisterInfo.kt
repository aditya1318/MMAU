package com.example.mmau.domain.model.usermodel




data class UserRegisterInfo(
    val `data`: Data,
    val token: String // 46600aa69058bdbc2a15b84282985e272926cce4
) {

    data class Data(
        val email: String, // test11@hotmail.com
        val first_name: String, // test
        val last_name: String, // test
        val username: String // test11
    )
}