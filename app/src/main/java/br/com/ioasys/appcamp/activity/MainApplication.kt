package br.com.ioasys.appcamp.activity

import android.app.Application
import br.com.ioasys.appcamp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                dataModule,
                dataRemoteModule,
                dataLocalModule,
                domainModule,
                databaseModule
            ).androidContext(applicationContext)
        }
    }
}