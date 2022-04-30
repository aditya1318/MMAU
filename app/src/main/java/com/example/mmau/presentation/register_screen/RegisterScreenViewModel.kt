package com.example.mmau.presentation.register_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mmau.domain.model.usermodel.UserLoginDetail
import com.example.mmau.domain.model.usermodel.UserRegisterInfo
import com.example.mmau.domain.model.usermodel.UserRegisterdetail
import com.example.mmau.use_cases.UserLoginUseCase
import com.example.mmau.use_cases.UserRegisterUseCase
import com.example.mmau.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModel @Inject constructor(
    private val userRegisterUseCase: UserRegisterUseCase
): ViewModel() {

    private val loginEventChannel = Channel<RegisterStateHandler>()
    val loginEventFlow =loginEventChannel.receiveAsFlow()

    fun loginUser(userRegisterdetail: UserRegisterdetail ){
        viewModelScope.launch(Dispatchers.IO){
            loginEventChannel.send(RegisterStateHandler.Loading)
              when(val result = userRegisterUseCase.invoke(userRegisterdetail)){
                 is Resource.Success<*> -> {
                     loginEventChannel.send(RegisterStateHandler.Success(result.data))
                 }
                 is Resource.Error<*> -> {
                     result.message?.let { RegisterStateHandler.Failure(it) }
                         ?.let { loginEventChannel.send(it) }
                 }



              }
        }
    }

}