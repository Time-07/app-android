package br.com.ioasys.appcamp.activity

import android.app.Application
import br.com.ioasys.appcamp.di.PresentationModule
import br.com.ioasys.appcamp.di.dataModule
import br.com.ioasys.appcamp.di.dataRemoteModule
import br.com.ioasys.appcamp.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

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