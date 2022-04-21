package br.com.ioasys.appcamp.presentation.adapter

import br.com.ioasys.appcamp.domain.model.Items
import br.com.ioasys.appcamp.domain.model.Professional

interface ProfessionalClickListener {

    fun onProfessionalClickListener(items: Items.Companion)
}