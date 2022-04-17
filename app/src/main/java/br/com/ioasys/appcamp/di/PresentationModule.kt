package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.presentation.viewmodel.LoginViewModel
import br.com.ioasys.appcamp.presentation.viewmodel.ProfessionalsListViewModel
import br.com.ioasys.appcamp.presentation.viewmodel.SingUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { SingUpViewModel() }
    viewModel { LoginViewModel() }
    viewModel { ProfessionalsListViewModel() }

}