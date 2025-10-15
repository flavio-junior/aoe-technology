package br.com.jr.aoe.technology.payment.data.datasource

import br.com.jr.aoe.technology.payment.data.api.PaymentApiService

class PaymentRemoteDataSourceImpl(
    private val paymentApiService: PaymentApiService
) : PaymentRemoteDataSource {

    override fun getAllPayments() {
        paymentApiService.getAllPayments()
    }
}
