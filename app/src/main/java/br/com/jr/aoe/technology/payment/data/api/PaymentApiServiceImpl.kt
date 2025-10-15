package br.com.jr.aoe.technology.payment.data.api

import retrofit2.http.GET

class PaymentApiServiceImpl : PaymentApiService {

    @GET(value = "https://60bd336db8ab3700175a03b3.mockapi.io/treinamento/payments")
    override fun getAllPayments() {
        TODO("Not yet implemented")
    }
}
