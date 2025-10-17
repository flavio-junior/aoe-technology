package br.com.jr.aoe.technology.network.di

import br.com.jr.aoe.technology.network.retrofit.provideConverterFactory
import br.com.jr.aoe.technology.network.retrofit.provideLoggingInterceptor
import br.com.jr.aoe.technology.network.retrofit.provideOkHttpClient
import br.com.jr.aoe.technology.network.retrofit.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    single {
        provideConverterFactory()
    }
    single {
        provideLoggingInterceptor()
    }
    single {
        provideOkHttpClient(loggingInterceptor = get())
    }
    single {
        provideRetrofit(okHttpClient = get(), gsonConverterFactory = get())
    }
}
