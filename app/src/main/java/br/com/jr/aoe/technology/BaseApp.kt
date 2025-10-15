package br.com.jr.aoe.technology

import android.app.Application
import br.com.jr.aoe.technology.account.di.accountModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@BaseApp)
            androidLogger(Level.INFO)
            modules(
                modules = listOf(
                    accountModule
                )
            )
        }
    }
}
