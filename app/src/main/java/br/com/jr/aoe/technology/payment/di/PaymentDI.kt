package br.com.jr.aoe.technology.payment.di

import br.com.jr.aoe.technology.payment.data.api.PaymentApiService
import br.com.jr.aoe.technology.payment.data.api.PaymentApiServiceImpl
import br.com.jr.aoe.technology.payment.data.datasource.PaymentRemoteDataSource
import br.com.jr.aoe.technology.payment.data.datasource.PaymentRemoteDataSourceImpl
import br.com.jr.aoe.technology.payment.data.repository.PaymentRepositoryImpl
import br.com.jr.aoe.technology.payment.ui.viewmodel.PaymentViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val paymentModule = module {
    single<PaymentApiService> {
        PaymentApiServiceImpl()
    }
    single<PaymentRemoteDataSource> {
        PaymentRemoteDataSourceImpl(paymentApiService = get())
    }
    single {
        PaymentRepositoryImpl(paymentRemoteDataSource = get())
    }
    viewModelOf(constructor = ::PaymentViewModel)
}
