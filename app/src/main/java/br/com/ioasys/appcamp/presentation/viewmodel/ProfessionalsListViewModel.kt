package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.usecase.GetProfessionalListUseCase
import br.com.ioasys.appcamp.domain.usecase.SaveProfessionalListUseCase
import br.com.ioasys.appcamp.util.ViewState
import br.com.ioasys.appcamp.util.postError
import br.com.ioasys.appcamp.util.postLoading
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class ProfessionalsListViewModel: ViewModel(), KoinComponent{

    private val getProfessionalListUseCase: GetProfessionalListUseCase by inject { parametersOf(viewModelScope) }
    private val saveProfessionalListUseCase: SaveProfessionalListUseCase by inject { parametersOf(viewModelScope) }

    private var _professionalListViewState = MutableLiveData<ViewState<List<Professional>>>()
    val professionalListViewState = _professionalListViewState as LiveData<ViewState<List<Professional>>>

    fun putProfessionalListOnView(){
        _professionalListViewState.postLoading()
        getProfessionalListUseCase(
            Unit,
            onSuccess = {
                saveProfessionals(professionalList = it)
            },
            onError = {
                _professionalListViewState.postError(it)
            }
        )
    }

    /* TODO(Você precisa de uma USECASE só para a pesquisa do filtro, eu te ajudo quando você for fazer.) */

//    fun search(input: String = "") {
//        _professionalListViewState.postLoading()
//        getProfessionalListUseCase(
//            params = GetProfessionalListUseCase.Params(
//                input = input
//            ),
//            onSuccess = {
//                _professionalListViewState.postSuccess(it)
//            },
//            onError = {
//                _professionalListViewState.postError(it)
//            }
//        )
//    }

     private fun saveProfessionals(professionalList: List<Professional>){
        saveProfessionalListUseCase(
            params = SaveProfessionalListUseCase.Params(
                professionalList = professionalList
            )
        )
    }

}