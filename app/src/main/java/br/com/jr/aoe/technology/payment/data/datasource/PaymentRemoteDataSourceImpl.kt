package br.com.jr.aoe.technology.payment.data.datasource

import android.content.Context
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import br.com.jr.aoe.technology.network.shared.toResultFlow
import br.com.jr.aoe.technology.payment.data.api.PaymentApiService
import br.com.jr.aoe.technology.payment.data.dto.PaymentResponseDTO
import kotlinx.coroutines.flow.Flow

class PaymentRemoteDataSourceImpl(
    private val context: Context,
    private val paymentApiService: PaymentApiService
) : PaymentRemoteDataSource {

    override fun getAllPayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>> {
        return toResultFlow(
            context = context,
            call = {
                paymentApiService.getAllPayments()
            }
        )
    }
}
