package br.com.jr.aoe.technology.feature.payment.data.repository

import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

interface PaymentRepository {
    fun getAllPayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>>
}
