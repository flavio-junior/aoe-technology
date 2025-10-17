package br.com.jr.aoe.technology.feature.account.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO
import br.com.jr.aoe.technology.feature.account.ui.viewmodel.AccountViewModel
import br.com.jr.aoe.technology.network.shared.Exceptions
import br.com.jr.aoe.technology.network.shared.Observer
import br.com.jr.aoe.technology.network.ui.view.UiResponse
import br.com.jr.aoe.technology.network.ui.view.UiState
import br.com.jr.aoe.technology.network.ui.viewmodel.LocalStorageViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun UiResponseSingInScreen(
    viewModel: AccountViewModel,
    goToAlternativeRoutes: (Exceptions) -> Unit = {},
    onError: (Observer) -> Unit = {},
    onResult: @Composable () -> Unit = {}
) {
    val uiState: UiState<LoginResponseVO>
            by viewModel.loginResponseVO.collectAsStateWithLifecycle()
    val localStorageViewModel: LocalStorageViewModel = koinViewModel()
    UiResponse(
        state = uiState,
        onError = {
            onError(it)
        },
        goToAlternativeRoutes = goToAlternativeRoutes,
        onSuccess = {
            localStorageViewModel.saveToken(loginResponseVO = it)
            viewModel.resetScreen()
            onResult()
        }
    )
}
