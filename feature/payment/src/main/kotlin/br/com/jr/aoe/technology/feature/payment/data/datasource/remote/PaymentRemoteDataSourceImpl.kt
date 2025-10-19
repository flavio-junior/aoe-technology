package br.com.jr.aoe.technology.feature.payment.data.datasource.remote

import android.content.Context
import br.com.jr.aoe.technology.feature.payment.data.api.PaymentApiService
import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.network.shared.ObserveNetworkStateHandler
import br.com.jr.aoe.technology.network.shared.toResultFlow
import kotlinx.coroutines.flow.Flow

class PaymentRemoteDataSourceImpl(
    private val context: Context,
    private val paymentApiService: PaymentApiService
) : PaymentRemoteDataSource {

    override fun getAllRemotePayments(): Flow<ObserveNetworkStateHandler<List<PaymentResponseDTO>>> {
        return toResultFlow(
            context = context,
            call = {
                paymentApiService.getAllRemotePayments()
            }
        )
    }
}
