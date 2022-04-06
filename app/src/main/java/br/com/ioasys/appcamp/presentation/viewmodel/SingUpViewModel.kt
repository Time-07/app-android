package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.ViewModel

class SingUpViewModel(): ViewModel() {

//    private var _singUpViewState = MutableLiveData<ViewState<List<SingUpItems>>>()
//    val singUpViewState = _singUpViewState as LiveData<ViewState<List<SingUpItems>>>

    var genre: String = null ?: ""
        private set


    fun setGenre(genreValue: String){
        genre = genreValue
    }
}