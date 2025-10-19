package br.com.jr.aoe.technology.feature.payment.data.repository

import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.feature.payment.data.storage.Payment
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

interface PaymentRepository {
    suspend fun saveAllPayments(vararg payments: Payment)
    suspend fun getAllLocalPayments(): List<Payment>
    fun getAllRemotePayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>>
    suspend fun deleteAllPayments()
}
