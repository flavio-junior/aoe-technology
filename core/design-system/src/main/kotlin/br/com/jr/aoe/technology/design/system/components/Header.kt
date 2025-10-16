package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.settings.Align
import br.com.jr.aoe.technology.design.system.specifications.WeightSize
import br.com.jr.aoe.technology.design.system.theme.Themes

@Composable
fun Header(
    label: String,
    align: Align = Align.START
) {
    if (align == Align.CENTER) {
        Title(
            label = label,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    } else {
        Row(
            modifier = Modifier
                .padding(all = Themes.size.spaceSize16),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconDefault(iconName = IconName.ARROW_BACK)
            Title(
                label = label,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(weight = WeightSize.WEIGHT_SIZE_1),
                textAlign = TextAlign.Center
            )
        }
    }
}
