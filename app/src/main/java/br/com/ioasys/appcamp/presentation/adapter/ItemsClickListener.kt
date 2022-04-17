package br.com.ioasys.appcamp.presentation.adapter

import br.com.ioasys.appcamp.domain.model.Items

interface ItemsClickListener {

    fun onItemsClickListener(items: Items)
}