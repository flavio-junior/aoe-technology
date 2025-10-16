package br.com.jr.aoe.technology.core

import android.app.Application
import br.com.jr.aoe.technology.feature.account.di.accountModule
import br.com.jr.aoe.technology.feature.payment.di.paymentModule
import br.com.jr.aoe.technology.network.di.networkModule
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
                    accountModule,
                    networkModule,
                    paymentModule
                )
            )
        }
    }
}
