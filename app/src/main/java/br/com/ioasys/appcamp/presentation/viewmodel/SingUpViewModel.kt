package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.appcamp.domain.model.SingUpItems
import br.com.ioasys.appcamp.domain.usecase.SingUpUseCase
import br.com.ioasys.appcamp.utils.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class SingUpViewModel: ViewModel(), KoinComponent {

    private val singUpUseCase: SingUpUseCase by inject { parametersOf(viewModelScope) }

    private var _singUpViewState = MutableLiveData<ViewState<List<SingUpItems>>>()
    val singUpViewState = _singUpViewState as LiveData<ViewState<List<SingUpItems>>>

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
        genre: String
    ){
        _singUpViewState.postLoading()
        singUpUseCase(
            params = SingUpUseCase.Params(
                user = user,
                email = email,
                password = password,
                confirmPassword = confirmPassword,
                gender = genre
            ),
            onSuccess = {
                _singUpViewState.postSuccess(listOf(it))
            },
            onError = {
                it.printStackTrace()
                _singUpViewState.postError(it)
            }
        )
    }


    fun  resetViewState(){
        _singUpViewState.postNeutral()
    }


}