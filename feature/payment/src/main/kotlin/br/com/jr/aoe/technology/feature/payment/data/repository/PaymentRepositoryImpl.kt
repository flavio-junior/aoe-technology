package br.com.jr.aoe.technology.feature.payment.data.repository

import br.com.jr.aoe.technology.feature.payment.data.datasource.local.PaymentLocalDataSource
import br.com.jr.aoe.technology.feature.payment.data.datasource.remote.PaymentRemoteDataSource
import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.feature.payment.data.storage.Payment
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

class PaymentRepositoryImpl(
    private val paymentRemoteDataSource: PaymentRemoteDataSource,
    private val paymentLocalDataSource: PaymentLocalDataSource
) : PaymentRepository {

    override suspend fun saveAllPayments(vararg payments: Payment) {
        paymentLocalDataSource.saveAllPayments(payments = payments)
    }

    override suspend fun getAllLocalPayments(): List<Payment> {
        return paymentLocalDataSource.getAllPayments()
    }

    override fun getAllRemotePayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>> {
        return paymentRemoteDataSource.getAllRemotePayments()
    }

    override suspend fun deleteAllPayments() {
        paymentLocalDataSource.deleteAllPayments()
    }
}
