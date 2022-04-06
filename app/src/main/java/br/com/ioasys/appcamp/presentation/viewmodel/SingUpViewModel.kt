package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.appcamp.domain.model.SingUpItems
import br.com.ioasys.appcamp.domain.usecase.SingUpUseCase
import br.com.ioasys.appcamp.utils.ViewState
import br.com.ioasys.appcamp.utils.postError
import br.com.ioasys.appcamp.utils.postLoading

class SingUpViewModel(
    private val singUpUseCase: SingUpUseCase
): ViewModel() {

    private var _singUpViewState = MutableLiveData<ViewState<List<SingUpItems>>>()
    val singUpViewState = _singUpViewState as LiveData<ViewState<List<SingUpItems>>>

    private var _genre: String = null ?: ""
    val genreValue: String = _genre


    fun setGenre(genreValue: String){
        _genre = genreValue
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
                genre = genre
            ),
            onSuccess = {

            },
            onError = {
                _singUpViewState.postError(it)
            }
        )
    }



}