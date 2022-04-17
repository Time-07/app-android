package br.com.ioasys.appcamp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.ioasys.appcamp.domain.model.Items
import br.com.ioasys.appcamp.util.ViewState
import br.com.ioasys.appcamp.util.postLoading

class ListItemViewModel {

    private var _listItemViewState = MutableLiveData<ViewState<List<Items>>>()
    val listItemViewModel = _listItemViewState as LiveData<ViewState<List<Items>>>

    fun putItemsOnView(){
        _listItemViewState.postLoading()
    }
    
    private fun saveItems(listItems: List<Items>){}
}