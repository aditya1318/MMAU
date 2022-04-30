package com.example.mmau.presentation.login_screen

import com.example.mmau.domain.model.usermodel.UserLoginInfo

sealed class LoginStateHandler {

    class  Success<T>(val result :T) : LoginStateHandler()
    class  Failure(val errorText : String) : LoginStateHandler()

    object Loading: LoginStateHandler()
    object Empty : LoginStateHandler()
}
