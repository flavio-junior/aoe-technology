package br.com.jr.aoe.technology.feature.payment.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.jr.aoe.technology.feature.payment.data.repository.PaymentRepository
import br.com.jr.aoe.technology.feature.payment.data.vo.PaymentResponseVO
import br.com.jr.aoe.technology.feature.payment.domain.ConverterPayment
import br.com.jr.aoe.technology.network.shared.DescriptionError
import br.com.jr.aoe.technology.network.ui.view.UiState
import br.com.jr.aoe.technology.network.ui.view.launchRequestWithResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PaymentViewModel(
    private val paymentRepository: PaymentRepository,
    private val converter: ConverterPayment
) : ViewModel(), PaymentViewModelImpl {

    private val _paymentsResponseVO =
        MutableStateFlow<UiState<List<PaymentResponseVO>>>(value = UiState.Init)
    val paymentsResponseVO = _paymentsResponseVO.asStateFlow()

    init {
        getAllPayments()
    }

    override fun getAllPayments() {
        launchRequestWithResponse(
            request = paymentRepository.getAllPayments(),
            state = _paymentsResponseVO,
            mapper = {
                converter.convertAllPaymentsDtoToVO(payments = it)
            }
        )
        _paymentsResponseVO.value = UiState.Error(error = DescriptionError())
    }
}
