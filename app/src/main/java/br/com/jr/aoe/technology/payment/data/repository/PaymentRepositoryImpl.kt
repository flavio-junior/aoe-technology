package br.com.jr.aoe.technology.payment.data.repository

import br.com.jr.aoe.technology.payment.data.datasource.PaymentRemoteDataSource

class PaymentRepositoryImpl(
    private val paymentRemoteDataSource: PaymentRemoteDataSource
) : PaymentRepository {

    override fun getAllPayments() {
        paymentRemoteDataSource.getAllPayments()
    }
}
