package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.appcamp.domain.usecase.LoginUseCase
import br.com.ioasys.appcamp.util.ViewState
import br.com.ioasys.appcamp.util.postError
import br.com.ioasys.appcamp.util.postNeutral
import br.com.ioasys.appcamp.util.postSuccess

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<String>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<String>>

    fun login(email: String, password: String) {
        loginUseCase(
            params = LoginUseCase.Params(
                email = email,
                password = password
            ),
            onSuccess = {
                _loggedUserViewState.postSuccess(it.accessToken)
            },
            onError = {
                _loggedUserViewState.postError(it)
            }
        )
    }

    fun resetViewState(){
        _loggedUserViewState.postNeutral()
    }
}