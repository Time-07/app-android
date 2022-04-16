package br.com.ioasys.appcamp.di

import androidx.room.Room
import br.com.ioasys.appcamp.data_local.database.ProfessionalDatabase
import br.com.ioasys.appcamp.data_local.utils.LocalConstants.PROFESSIONAL_DATABASE_NAME
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            ProfessionalDatabase::class.java,
            PROFESSIONAL_DATABASE_NAME
        ).build()
    }

    single { get<ProfessionalDatabase>().professionalDao() }

}