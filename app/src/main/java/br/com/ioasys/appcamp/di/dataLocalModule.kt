package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.data.data_local.datasource.ProfessionalsLocalDataSourceImpl
import br.com.ioasys.appcamp.data.data_local.utils.SharedPreferencesHelper
import br.com.ioasys.appcamp.data.datasource.local.LoginLocalDataSource
import br.com.ioasys.appcamp.data.datasource.local.ProfessionalsLocalDataSource
import br.com.ioasys.appcamp.data_local.datasource.LoginLocalDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataLocalModule = module {

    single { SharedPreferencesHelper(androidContext()) }
    single<LoginLocalDataSource> { LoginLocalDataSourceImpl( get()) }
    single<ProfessionalsLocalDataSource> { ProfessionalsLocalDataSourceImpl(get(), get()) }

}