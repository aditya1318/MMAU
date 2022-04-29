package com.example.mmau.presentation.register_screen

sealed class RegisterStateHandler {

    class  Success<T>(val result :T) : RegisterStateHandler()
    class  Failure(val errorText : String) : RegisterStateHandler()

    object Loading: RegisterStateHandler()
    object Empty : RegisterStateHandler()
}
