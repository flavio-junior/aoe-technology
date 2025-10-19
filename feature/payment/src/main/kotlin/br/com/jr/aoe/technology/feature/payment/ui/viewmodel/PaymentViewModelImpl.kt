package br.com.jr.aoe.technology.feature.payment.ui.viewmodel

import br.com.jr.aoe.technology.feature.payment.data.vo.PaymentResponseVO

interface PaymentViewModelImpl {
    fun saveAllPayments(paymentResponseVO: List<PaymentResponseVO>)
    fun getAllLocalPayments()
    fun getAllRemotePayments()
    fun deletePayment()
}
