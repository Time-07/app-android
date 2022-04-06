package br.com.ioasys.transapp.di

import br.com.ioasys.appcamp.presentation.viewmodel.SingUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { SingUpViewModel() }
}