package br.com.jr.aoe.technology.payment.data.vo

import kotlinx.serialization.Serializable

@Serializable
data class PaymentResponseVO(
    val id: Long? = 0,
    val paymentDate: String? = "",
    val electricityBill: Double? = 0.0
)
