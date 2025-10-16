package br.com.jr.aoe.technology.feature.payment.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PaymentResponseDTO(
    val id: Long? = 0,
    val paymentDate: String? = "",
    val electricityBill: Double? = 0.0
)
