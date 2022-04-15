package br.com.ioasys.appcamp.di

import androidx.room.Room
import br.com.ioasys.appcamp.data.data_local.utils.LocalConstants.PROFISSIONAL_DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

//val databaseModule = module {
//
//    single {
//        Room.databaseBuilder(
//            androidContext(),
//            ProfissionalDatabase::class.java
//
//        )
//    }
//}