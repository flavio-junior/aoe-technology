package br.com.jr.aoe.technology.payment.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.jr.aoe.technology.components.LoadingData
import br.com.jr.aoe.technology.network.shared.Exceptions
import br.com.jr.aoe.technology.network.ui.UiResponse
import br.com.jr.aoe.technology.network.ui.UiState
import br.com.jr.aoe.technology.payment.data.vo.PaymentResponseVO
import br.com.jr.aoe.technology.payment.ui.viewmodel.PaymentViewModel

@Composable
fun UiResponseFindAllPaymentsScreen(
    viewModel: PaymentViewModel,
    goToAlternativeRoutes: (Exceptions) -> Unit = {},
    onResult: @Composable (List<PaymentResponseVO>) -> Unit = {}
) {
    val uiState: UiState<List<PaymentResponseVO>> by viewModel.paymentsResponseVO.collectAsStateWithLifecycle()
    UiResponse(
        state = uiState,
        onLoading = {
            LoadingData()
        },
        onError = {
        },
        goToAlternativeRoutes = goToAlternativeRoutes,
        onSuccess = {
            onResult(it)
        }
    )
}
