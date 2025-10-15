package br.com.jr.aoe.technology.account.di

import br.com.jr.aoe.technology.account.data.api.AccountApiService
import br.com.jr.aoe.technology.account.data.api.AccountApiServiceImpl
import br.com.jr.aoe.technology.account.data.datasource.AccountRemoteDataSource
import br.com.jr.aoe.technology.account.data.datasource.AccountRemoteDataSourceImpl
import br.com.jr.aoe.technology.account.data.repository.AccountRepository
import br.com.jr.aoe.technology.account.data.repository.AccountRepositoryImpl
import br.com.jr.aoe.technology.account.domain.ConverterAccount
import br.com.jr.aoe.technology.account.ui.viewmodel.AccountViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val accountModule = module {
    single<AccountApiService> {
        AccountApiServiceImpl()
    }
    single<AccountRemoteDataSource> {
        AccountRemoteDataSourceImpl(accountApiService = get())
    }
    single<AccountRepository> {
        AccountRepositoryImpl(accountRemoteDataSource = get())
    }
    single {
        ConverterAccount()
    }
    viewModelOf(constructor = ::AccountViewModel)
}
