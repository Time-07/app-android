package br.com.ioasys.appcamp.activity

import android.app.Application
import br.com.ioasys.appcamp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                PresentationModule,
                domainModule,
                dataModule,
                dataRemoteModule
            ).androidContext(applicationContext)
        }
    }
}