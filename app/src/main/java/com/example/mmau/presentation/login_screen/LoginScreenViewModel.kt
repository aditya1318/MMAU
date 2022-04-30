package com.example.mmau.presentation.login_screen

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mmau.domain.model.usermodel.UserLoginDetail
import com.example.mmau.use_cases.UserLoginUseCase
import com.example.mmau.util.Resource
import com.example.mmau.util.UserPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val useLoginUseCase :UserLoginUseCase
): ViewModel() {

    private val loginEventChannel = Channel<LoginStateHandler>()
    val loginEventFlow =loginEventChannel.receiveAsFlow()

    fun loginUser(userLoginDetail: UserLoginDetail){
        viewModelScope.launch(Dispatchers.IO){
            loginEventChannel.send(LoginStateHandler.Loading)
              when(val result = useLoginUseCase.invoke(userLoginDetail)){
                 is Resource.Success<*> -> {

                     loginEventChannel.send(LoginStateHandler.Success(result.data))
                 }
                 is Resource.Error<*> -> {
                     result.message?.let { LoginStateHandler.Failure(it) }
                         ?.let { loginEventChannel.send(it) }
                 }



              }
        }
    }

}