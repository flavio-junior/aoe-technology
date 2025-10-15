package br.com.jr.aoe.technology.payment.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.jr.aoe.technology.network.ui.UiState
import br.com.jr.aoe.technology.network.ui.launchRequestWithResponse
import br.com.jr.aoe.technology.payment.data.repository.PaymentRepository
import br.com.jr.aoe.technology.payment.data.vo.PaymentResponseVO
import br.com.jr.aoe.technology.payment.domain.ConverterPayment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaymentViewModel(
    private val paymentRepository: PaymentRepository,
    private val converter: ConverterPayment
) : ViewModel(), PaymentViewModelImpl {

    private val _paymentsResponseVO =
        MutableStateFlow<UiState<List<PaymentResponseVO>>>(value = UiState.Init)
    val paymentsResponseVO = _paymentsResponseVO.asStateFlow()

    override fun getAllPayments() {
        launchRequestWithResponse(
            request = paymentRepository.getAllPayments(),
            state = _paymentsResponseVO,
            mapper = {
                converter.convertAllPaymentsDtoToVO(payments = it)
            }
        )
    }
}
