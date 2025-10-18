package br.com.jr.aoe.technology.feature.payment.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.jr.aoe.technology.design.system.components.Description
import br.com.jr.aoe.technology.design.system.components.SubTitle
import br.com.jr.aoe.technology.design.system.specifications.TypeFont
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.feature.payment.R

@Composable
fun DetailsUser(
    balance: String,
    client: String,
    agency: String,
    account: String
) {
    SubTitle(
        label = stringResource(id = R.string.details_payments),
        typeFont = TypeFont.EXTRA_BOLD,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Themes.size.spaceSize24)
    )
    Column {
        Description(
            label = stringResource(id = R.string.client, client),
            modifier = Modifier.fillMaxWidth()
        )
        Description(
            label = "${
                stringResource(
                    id = R.string.agency,
                    agency
                )
            } | ${
                stringResource(
                    id = R.string.account,
                    account
                )
            }",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Themes.size.spaceSize24),
            color = Themes.colors.inputText,
            typeFont = TypeFont.LIGHT
        )
        Description(
            label = stringResource(id = R.string.balance, balance),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = Themes.size.spaceSize24),
            typeFont = TypeFont.LIGHT
        )
    }
}
