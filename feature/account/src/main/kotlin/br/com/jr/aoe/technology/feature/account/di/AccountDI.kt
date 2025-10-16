package br.com.jr.aoe.technology.feature.account.di

import br.com.jr.aoe.technology.feature.account.data.api.AccountApiService
import br.com.jr.aoe.technology.feature.account.data.datasource.AccountRemoteDataSource
import br.com.jr.aoe.technology.feature.account.data.datasource.AccountRemoteDataSourceImpl
import br.com.jr.aoe.technology.feature.account.data.repository.AccountRepository
import br.com.jr.aoe.technology.feature.account.data.repository.AccountRepositoryImpl
import br.com.jr.aoe.technology.feature.account.domain.ConverterAccount
import br.com.jr.aoe.technology.feature.account.ui.viewmodel.AccountViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit

val accountModule = module {
    single {
        get<Retrofit>().create(AccountApiService::class.java)
    }
    single<AccountRemoteDataSource> {
        AccountRemoteDataSourceImpl(context = androidContext(), accountApiService = get())
    }
    single<AccountRepository> {
        AccountRepositoryImpl(accountRemoteDataSource = get())
    }
    single {
        ConverterAccount()
    }
    viewModelOf(constructor = ::AccountViewModel)
}
