package br.com.jr.aoe.technology.feature.payment.di

import br.com.jr.aoe.technology.feature.payment.data.api.PaymentApiService
import br.com.jr.aoe.technology.feature.payment.data.datasource.PaymentRemoteDataSource
import br.com.jr.aoe.technology.feature.payment.data.datasource.PaymentRemoteDataSourceImpl
import br.com.jr.aoe.technology.feature.payment.data.repository.PaymentRepositoryImpl
import br.com.jr.aoe.technology.feature.payment.domain.ConverterPayment
import br.com.jr.aoe.technology.feature.payment.ui.viewmodel.PaymentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val paymentModule = module {
    single {
        get<Retrofit>().create(PaymentApiService::class.java)
    }
    single<PaymentRemoteDataSource> {
        PaymentRemoteDataSourceImpl(context = androidContext(), paymentApiService = get())
    }
    single {
        PaymentRepositoryImpl(paymentRemoteDataSource = get())
    }
    single {
        ConverterPayment()
    }
    viewModel {
        PaymentViewModel(
            paymentRepository = get(),
            converter = get()
        )
    }
}
