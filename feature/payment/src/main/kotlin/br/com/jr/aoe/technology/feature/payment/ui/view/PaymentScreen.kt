package br.com.jr.aoe.technology.feature.payment.ui.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import br.com.jr.aoe.technology.design.system.components.Header
import br.com.jr.aoe.technology.design.system.components.SubTitle
import br.com.jr.aoe.technology.design.system.components.Title
import br.com.jr.aoe.technology.design.system.specifications.TypeFont
import br.com.jr.aoe.technology.design.system.specifications.WeightSize
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.feature.payment.R
import br.com.jr.aoe.technology.feature.payment.ui.viewmodel.PaymentViewModel
import br.com.jr.aoe.technology.navigation.AppDestinations
import br.com.jr.aoe.technology.network.ui.viewmodel.LocalStorageViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun PaymentScreen(
    goToSignInScreen: (AppDestinations) -> Unit = {},
    goToAlternativeRoutes: () -> Unit = {},
    exitApp: () -> Unit = {}
) {
    val viewModel: PaymentViewModel = koinViewModel()
    val localStorageViewModel: LocalStorageViewModel = koinViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Themes.size.spaceSize16),
        verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize16)
    ) {
        Header(
            label = stringResource(id = R.string.payments),
            onClick = {
                localStorageViewModel.cleanToken()
                goToSignInScreen(AppDestinations.SplashScreen)
            }
        )
        BackHandler(enabled = true, onBack = exitApp)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .weight(weight = WeightSize.WEIGHT_SIZE_1),
            verticalArrangement = Arrangement.Center
        ) {
            UiResponseFindAllPaymentsScreen(
                viewModel = viewModel,
                onError = {
                    if (it.error)
                        Title(label = stringResource(id = R.string.none_payment))
                },
                goToAlternativeRoutes = goToAlternativeRoutes,
                onResult = {
                    DetailsUser(
                        balance = "1.500,00",
                        client = "Maria Silva",
                        agency = "1234",
                        account = "56789-0"
                    )
                    SubTitle(
                        label = stringResource(id = R.string.bills_paid),
                        typeFont = TypeFont.EXTRA_BOLD,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxWidth()
                    )
                    it.forEach { payment ->
                        CardPayment(
                            price = payment.electricityBill.toString(),
                            date = payment.paymentDate.toString()
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(height = Themes.size.spaceSize64))
        }
    }
}
