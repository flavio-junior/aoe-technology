package br.com.jr.aoe.technology.payment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jr.aoe.technology.payment.data.repository.PaymentRepository
import br.com.jr.aoe.technology.payment.domain.ConverterPayment
import kotlinx.coroutines.launch

class PaymentViewModel(
    private val paymentRepository: PaymentRepository,
    private val converter: ConverterPayment
) : ViewModel(), PaymentViewModelImpl {

    override fun getAllPayments() {
        viewModelScope.launch {
            paymentRepository.getAllPayments()
        }
    }
}
