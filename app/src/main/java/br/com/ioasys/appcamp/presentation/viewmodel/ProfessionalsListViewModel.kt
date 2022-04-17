package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ioasys.appcamp.domain.model.Professional
import br.com.ioasys.appcamp.domain.usecase.GetProfessionalListUseCase
import br.com.ioasys.appcamp.domain.usecase.SaveProfessionalListUseCase
import br.com.ioasys.appcamp.util.ViewState
import br.com.ioasys.appcamp.util.postError
import br.com.ioasys.appcamp.util.postLoading
import br.com.ioasys.appcamp.util.postSuccess

class ProfessionalsListViewModel(
    private val getProfessionalListUseCase: GetProfessionalListUseCase,
    private val saveProfessionalListUseCase: SaveProfessionalListUseCase
): ViewModel(){

    private val _professionalListViewState = MutableLiveData<ViewState<List<Professional>>>()
    val professionalListViewState = _professionalListViewState as LiveData<ViewState<List<Professional>>>

    fun search(input: String = "") {
        _professionalListViewState.postLoading()
        getProfessionalListUseCase(
            params = GetProfessionalListUseCase.Params(
                input = input
            ),
            onSuccess = {
                saveProfessionals(professionalList = it)
                _professionalListViewState.postSuccess(it)
            },
            onError = {
                _professionalListViewState.postError(it)
            }
        )
    }

    private fun saveProfessionals(professionalList: List<Professional>){
        saveProfessionalListUseCase(
            params = SaveProfessionalListUseCase.Params(
                professionalList = professionalList
            )
        )
    }

}