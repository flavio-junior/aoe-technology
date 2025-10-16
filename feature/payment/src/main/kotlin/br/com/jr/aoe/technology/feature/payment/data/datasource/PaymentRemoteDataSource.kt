package br.com.jr.aoe.technology.feature.payment.data.datasource

import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import kotlinx.coroutines.flow.Flow

interface PaymentRemoteDataSource {
    fun getAllPayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>>
}
