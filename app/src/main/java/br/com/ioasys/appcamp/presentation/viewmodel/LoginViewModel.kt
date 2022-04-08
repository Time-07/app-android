package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.appcamp.domain.model.User
import br.com.ioasys.appcamp.domain.usecase.LoginUseCase
import br.com.ioasys.appcamp.utils.ViewState
import br.com.ioasys.appcamp.utils.postError
import br.com.ioasys.appcamp.utils.postNeutral
import br.com.ioasys.appcamp.utils.postSuccess



class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loggedUserViewState = MutableLiveData<ViewState<List<User>>>()
    val loggedUserViewState = _loggedUserViewState as LiveData<ViewState<List<User>>>

    fun login(email: String, password: String) {
        loginUseCase(
            params = LoginUseCase.Params(
                email = email,
                password = password
            ),
            onSuccess = {
                _loggedUserViewState.postSuccess(
                    data = listOf(
                        User(
                            email,
                            password
                        )))

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