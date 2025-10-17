package br.com.jr.aoe.technology.network.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.jr.aoe.technology.common.account.vo.LoginResponseVO
import br.com.jr.aoe.technology.network.ui.viewmodel.LocalStorageViewModel
import org.koin.mp.KoinPlatform.getKoin

@Composable
fun UiResponseGetTokenSaved(
    goToSignInScreen: () -> Unit = {},
    goToPaymentScreen: () -> Unit = {}
) {
    val viewModel: LocalStorageViewModel = getKoin().get()
    val uiState: UiState<LoginResponseVO?> by viewModel.getTokenSaved.collectAsStateWithLifecycle()
    UiResponse(
        state = uiState,
        onLoading = {},
        onError = {},
        onSuccess = {
            if (it?.customerName?.isNotBlank() == true) {
                goToPaymentScreen()
            } else {
                goToSignInScreen()
            }
        }
    )
}
