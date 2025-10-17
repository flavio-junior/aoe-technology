package br.com.jr.aoe.technology.feature.payment.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import br.com.jr.aoe.technology.design.system.components.Description
import br.com.jr.aoe.technology.design.system.specifications.TypeFont
import br.com.jr.aoe.technology.design.system.specifications.WeightSize
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.feature.payment.R

@Composable
fun CardPayment(
    price: String,
    date: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.weight(weight = WeightSize.WEIGHT_SIZE_1),
            verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize4)

        ) {
            Description(label = stringResource(id = R.string.electricity))
            Description(
                label = price,
                color = Themes.colors.inputText,
                typeFont = TypeFont.LIGHT
            )
        }
        Description(
            label = date,
            modifier = Modifier.weight(weight = WeightSize.WEIGHT_SIZE_1),
            textAlign = TextAlign.End,
            color = Themes.colors.inputText,
            typeFont = TypeFont.LIGHT
        )
    }
}
