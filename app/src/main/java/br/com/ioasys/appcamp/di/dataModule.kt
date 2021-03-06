package br.com.ioasys.appcamp.di

import br.com.ioasys.appcamp.data.repositories.LoginRepositoryImpl
import br.com.ioasys.appcamp.data.repositories.ProfessionalsRepositoryImpl
import br.com.ioasys.appcamp.data.repositories.SingUpRepositoryImpl
import br.com.ioasys.appcamp.domain.respositories.LoginRepository
import br.com.ioasys.appcamp.domain.respositories.ProfessionalsRepository
import br.com.ioasys.appcamp.domain.respositories.SingUpRepository
import org.koin.dsl.module

val dataModule = module {

      single<SingUpRepository> { SingUpRepositoryImpl(get()) }
      single<LoginRepository> { LoginRepositoryImpl(get(), get()) }
      single<ProfessionalsRepository>{ ProfessionalsRepositoryImpl(get(), get()) }


}
