package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.appcamp.domain.usecase.SearchUseCase
import br.com.ioasys.appcamp.domain.usecase.SignUpUseCase
import br.com.ioasys.appcamp.util.ViewState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class SearchViewModel: ViewModel(), KoinComponent {

    private val searchUseCase: SearchUseCase by inject { parametersOf(viewModelScope) }

    private var _searchViewState = MutableLiveData<ViewState<List<String>>>()
    val searchViewState = _searchViewState as LiveData<ViewState<List<String>>>

}