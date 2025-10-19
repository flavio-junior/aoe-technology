package br.com.jr.aoe.technology.feature.payment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jr.aoe.technology.feature.payment.data.repository.PaymentRepository
import br.com.jr.aoe.technology.feature.payment.data.storage.Payment
import br.com.jr.aoe.technology.feature.payment.data.vo.PaymentResponseVO
import br.com.jr.aoe.technology.feature.payment.domain.ConverterPayment
import br.com.jr.aoe.technology.network.ui.view.UiState
import br.com.jr.aoe.technology.network.ui.view.launchRequestWithResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PaymentViewModel(
    private val paymentRepository: PaymentRepository,
    private val converter: ConverterPayment
) : ViewModel(), PaymentViewModelImpl {

    private val _getAllLocalPayments =
        MutableStateFlow<List<PaymentResponseVO>>(value = emptyList())
    val getAllLocalPayments = _getAllLocalPayments.asStateFlow()

    private val _getAllRemotePayments =
        MutableStateFlow<UiState<List<PaymentResponseVO>>>(value = UiState.Init)
    val getAllRemotePayments = _getAllRemotePayments.asStateFlow()

    init {
        getAllLocalPayments()
    }

    override fun saveAllPayments(paymentResponseVO: List<PaymentResponseVO>) {
        viewModelScope.launch {
            val payment = converter.convertPaymentVoToPayment(payments = paymentResponseVO)
            paymentRepository.saveAllPayments(payments = payment)
            _getAllLocalPayments.value = paymentResponseVO
        }
    }

    override fun getAllLocalPayments() {
        viewModelScope.launch {
            _getAllLocalPayments.value = converter.convertAllPaymentsToVO(
                payments = paymentRepository.getAllLocalPayments()
            )
        }
    }

    override fun getAllRemotePayments() {
        launchRequestWithResponse(
            request = paymentRepository.getAllRemotePayments(),
            state = _getAllRemotePayments,
            mapper = {
                converter.convertAllPaymentsDtoToVO(payments = it)
            }
        )
    }

    override fun deletePayment(payment: Payment) {
        viewModelScope.launch {
            paymentRepository.deletePayment(payment = payment)
        }
    }
}
