package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.data.repositories.SingUpRepositoryImpl
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {

      single<SingUpRepository> { SingUpRepositoryImpl() }
}