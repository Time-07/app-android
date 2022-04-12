package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.data_remote.service.AuthService
import br.com.ioasys.appcamp.data_remote.utils.ApiConstants
import br.com.ioasys.appcamp.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single<AuthService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

}