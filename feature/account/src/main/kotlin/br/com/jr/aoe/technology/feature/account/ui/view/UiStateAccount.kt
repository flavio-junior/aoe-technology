package br.com.jr.aoe.technology.feature.account.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.jr.aoe.technology.design.system.LoadingData
import br.com.jr.aoe.technology.feature.account.data.vo.LoginResponseVO
import br.com.jr.aoe.technology.feature.account.ui.viewmodel.AccountViewModel
import br.com.jr.aoe.technology.network.shared.Exceptions
import br.com.jr.aoe.technology.network.shared.Observer
import br.com.jr.aoe.technology.network.ui.UiResponse
import br.com.jr.aoe.technology.network.ui.UiState

@Composable
fun UiResponseSingInScreen(
    viewModel: AccountViewModel,
    goToAlternativeRoutes: (Exceptions) -> Unit = {},
    onError: (Observer) -> Unit = {},
    onResult: @Composable (LoginResponseVO) -> Unit = {}
) {
    val uiState: UiState<LoginResponseVO>
            by viewModel.loginResponseVO.collectAsStateWithLifecycle()
    UiResponse(
        state = uiState,
        onError = {
            onError(it)
        },
        goToAlternativeRoutes = goToAlternativeRoutes,
        onSuccess = {
            onResult(it)
        }
    )
}
