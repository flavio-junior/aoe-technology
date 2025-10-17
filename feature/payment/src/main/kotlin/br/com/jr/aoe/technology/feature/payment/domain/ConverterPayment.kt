package br.com.jr.aoe.technology.feature.payment.domain

import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.feature.payment.data.vo.PaymentResponseVO

class ConverterPayment {

    fun convertAllPaymentsDtoToVO(
        payments: List<PaymentResponseDTO>? = null
    ): List<PaymentResponseVO> {
        return payments?.map { payment ->
            PaymentResponseVO(
                id = payment.id,
                paymentDate = payment.paymentDate,
                electricityBill = payment.electricityBill
            )
        } ?: emptyList()
    }
}
