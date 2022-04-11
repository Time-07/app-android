package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single { WebServiceFactory.providerOkHttpClient() }

}