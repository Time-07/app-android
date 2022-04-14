package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.appcamp.domain.model.SignUpItems
import br.com.ioasys.appcamp.domain.usecase.SignUpUseCase
import br.com.ioasys.appcamp.utils.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class SingUpViewModel: ViewModel(), KoinComponent {

    private val signUpUseCase: SignUpUseCase by inject { parametersOf(viewModelScope) }

    private var _singUpViewState = MutableLiveData<ViewState<List<Boolean>>>()
    val singUpViewState = _singUpViewState as LiveData<ViewState<List<Boolean>>>

    var gender: String = ""
        private set

    fun setGender(text: String){
        gender = text
    }

    fun singUp(
        user: String,
        email: String,
        password: String,
        confirmPassword: String,
        genre: String,
        cpf: String
    ){
        _singUpViewState.postLoading()
        signUpUseCase(
            params = SignUpUseCase.SignUpModels(
                user = user,
                email = email,
                password = password,
                confirmPassword = confirmPassword,
                gender = genre,
                cpf = cpf
            ),
            onSuccess = {
                _singUpViewState.postSuccess(listOf(it))
            },
            onError = {
                _singUpViewState.postError(it)
            }
        )
    }


    fun  resetViewState(){
        _singUpViewState.postNeutral()
    }


}