package br.com.jr.aoe.technology.feature.payment.data.api

import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface PaymentApiService {

    @GET(value = "treinamento/payments")
    suspend fun getAllPayments(): Response<List<PaymentResponseDTO>>
}
