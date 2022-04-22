package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.data.datasource.remote.LoginRemoteDataSource
import br.com.ioasys.appcamp.data.datasource.remote.ProfessionalsRemoteDataSource
import br.com.ioasys.appcamp.data_remote.datasource.LoginRemoteDataSourceImpl
import br.com.ioasys.appcamp.data.datasource.remote.SingUpRemoteDataSource
import br.com.ioasys.appcamp.data_remote.datasource.ProfessionalsRemoteDataSourceImpl
import br.com.ioasys.appcamp.data_remote.datasource.SingUpRemoteDataSourceImpl
import br.com.ioasys.appcamp.data_remote.service.AuthService
import br.com.ioasys.appcamp.data_remote.service.ProfessionalService
import br.com.ioasys.appcamp.data_remote.service.SingUpService
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

    single<SingUpService> {
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single<ProfessionalService>{
        WebServiceFactory.createWebService(
            okHttpClient = get(),
            url = ApiConstants.BASE_URL
        )
    }

    single { WebServiceFactory.providerOkHttpClient() }

    single<LoginRemoteDataSource> {
        LoginRemoteDataSourceImpl(get())
    }

    single<SingUpRemoteDataSource> {
        SingUpRemoteDataSourceImpl(get())
    }

    single<ProfessionalsRemoteDataSource> {
        ProfessionalsRemoteDataSourceImpl(get())
    }

}