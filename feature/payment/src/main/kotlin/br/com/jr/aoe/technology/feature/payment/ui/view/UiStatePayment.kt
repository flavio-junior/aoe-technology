package br.com.jr.aoe.technology.feature.payment.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.jr.aoe.technology.design.system.LoadingData
import br.com.jr.aoe.technology.feature.payment.data.vo.PaymentResponseVO
import br.com.jr.aoe.technology.feature.payment.ui.viewmodel.PaymentViewModel
import br.com.jr.aoe.technology.network.ui.view.UiResponse
import br.com.jr.aoe.technology.network.ui.view.UiState

@Composable
fun UiResponseFindAllPaymentsScreen(
    viewModel: PaymentViewModel,
    onError: @Composable () -> Unit = {},
    goToAlternativeRoutes: () -> Unit = {},
    onResult: @Composable (List<PaymentResponseVO>) -> Unit = {}
) {
    val uiState: UiState<List<PaymentResponseVO>> by viewModel.paymentsResponseVO.collectAsStateWithLifecycle()
    UiResponse(
        state = uiState,
        onLoading = {
            LoadingData()
        },
        onError = {
            onError
        },
        goToAlternativeRoutes = goToAlternativeRoutes,
        onSuccess = {
            onResult(it)
        }
    )
}
