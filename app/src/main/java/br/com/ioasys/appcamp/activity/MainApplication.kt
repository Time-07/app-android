package br.com.ioasys.appcamp.activity

import android.app.Application
import br.com.ioasys.transapp.di.domainModule
import br.com.ioasys.transapp.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                presentationModule,
                domainModule
            ).androidContext(applicationContext)
        }
    }
}