package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.appcamp.domain.model.SingUpItems
import br.com.ioasys.appcamp.domain.usecase.SingUpUseCase
import br.com.ioasys.appcamp.utils.*

class SingUpViewModel(
    private val singUpUseCase: SingUpUseCase
): ViewModel() {

    private var _singUpViewState = MutableLiveData<ViewState<List<SingUpItems>>>()
    val singUpViewState = _singUpViewState as LiveData<ViewState<List<SingUpItems>>>

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
                genre = genre
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