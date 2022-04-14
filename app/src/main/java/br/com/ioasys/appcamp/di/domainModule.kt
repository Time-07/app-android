package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.domain.usecase.LoginUseCase
import br.com.ioasys.appcamp.domain.usecase.SignUpUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val domainModule = module {

    single { CoroutineScope(Dispatchers.IO) }

    factory { (scope:CoroutineScope) ->
        SignUpUseCase(get(), scope) }
    factory { LoginUseCase(get(), get()) }
}