package br.com.jr.aoe.technology.feature.payment.domain

import br.com.jr.aoe.technology.feature.payment.data.dto.PaymentResponseDTO
import br.com.jr.aoe.technology.feature.payment.data.storage.Payment
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

    fun convertPaymentVoToPayment(
        payments: List<PaymentResponseVO>
    ): Array<Payment> {
        val result = payments.map { payment ->
            Payment(
                id = payment.id,
                paymentDate = payment.paymentDate,
                electricityBill = payment.electricityBill
            )
        }
        return result.toTypedArray()
    }

    fun convertAllPaymentsToVO(
        payments: List<Payment>
    ): List<PaymentResponseVO> {
        return payments.map {
            PaymentResponseVO(
                id = it.id,
                paymentDate = it.paymentDate,
                electricityBill = it.electricityBill
            )
        }
    }
}
