package br.com.jr.aoe.technology.network.di

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import br.com.jr.aoe.technology.network.data.datasource.local.LocalStorageDataSource
import br.com.jr.aoe.technology.network.data.datasource.local.LocalStorageDataSourceImpl
import br.com.jr.aoe.technology.network.data.repository.LocalStorageRepository
import br.com.jr.aoe.technology.network.data.repository.LocalStorageRepositoryImpl
import br.com.jr.aoe.technology.network.retrofit.provideConverterFactory
import br.com.jr.aoe.technology.network.retrofit.provideLoggingInterceptor
import br.com.jr.aoe.technology.network.retrofit.provideOkHttpClient
import br.com.jr.aoe.technology.network.retrofit.provideRetrofit
import br.com.jr.aoe.technology.network.ui.viewmodel.LocalStorageViewModel
import br.com.jr.aoe.technology.network.utils.NetworkUtils.LOCAL_STORAGE
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
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
    single<LocalStorageDataSource> {
        LocalStorageDataSourceImpl(dataStore = get())
    }
    single {
        PreferenceDataStoreFactory.create {
            androidContext().preferencesDataStoreFile(name = LOCAL_STORAGE)
        }
    }
    single<LocalStorageRepository> {
        LocalStorageRepositoryImpl(localStorageDataSource = get())
    }
    viewModel {
        LocalStorageViewModel(localStorageRepository = get())
    }
}
