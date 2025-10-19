package br.com.jr.aoe.technology.feature.payment.di

import androidx.room.Room
import br.com.jr.aoe.technology.feature.payment.data.api.PaymentApiService
import br.com.jr.aoe.technology.feature.payment.data.datasource.local.PaymentLocalDataSource
import br.com.jr.aoe.technology.feature.payment.data.datasource.local.PaymentLocalDataSourceImpl
import br.com.jr.aoe.technology.feature.payment.data.datasource.remote.PaymentRemoteDataSource
import br.com.jr.aoe.technology.feature.payment.data.datasource.remote.PaymentRemoteDataSourceImpl
import br.com.jr.aoe.technology.feature.payment.data.repository.PaymentRepository
import br.com.jr.aoe.technology.feature.payment.data.repository.PaymentRepositoryImpl
import br.com.jr.aoe.technology.feature.payment.domain.ConverterPayment
import br.com.jr.aoe.technology.feature.payment.ui.viewmodel.PaymentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val paymentModule = module {
    single<PaymentLocalDataSource> {
        get<PaymentLocalDataSourceImpl>().paymentDao()
    }
    single {
        Room.databaseBuilder(
            context = androidContext(),
            klass = PaymentLocalDataSourceImpl::class.java,
            name = "payment_database"
        ).build()
    }
    single {
        get<Retrofit>().create(PaymentApiService::class.java)
    }
    single<PaymentRemoteDataSource> {
        PaymentRemoteDataSourceImpl(context = androidContext(), paymentApiService = get())
    }
    single<PaymentRepository> {
        PaymentRepositoryImpl(
            paymentRemoteDataSource = get(),
            paymentLocalDataSource = get()
        )
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
