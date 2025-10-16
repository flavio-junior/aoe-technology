package br.com.jr.aoe.technology.feature.payment.data.repository

import br.com.jr.aoe.technology.feature.payment.data.datasource.PaymentRemoteDataSource
import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

class PaymentRepositoryImpl(
    private val paymentRemoteDataSource: PaymentRemoteDataSource
) : PaymentRepository {

    override fun getAllPayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>> {
        return paymentRemoteDataSource.getAllPayments()
    }
}
