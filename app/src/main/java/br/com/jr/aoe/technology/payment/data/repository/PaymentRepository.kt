package br.com.jr.aoe.technology.payment.data.repository

import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import br.com.jr.aoe.technology.payment.data.dto.PaymentResponseDTO
import kotlinx.coroutines.flow.Flow

interface PaymentRepository {
    fun getAllPayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>>
}
