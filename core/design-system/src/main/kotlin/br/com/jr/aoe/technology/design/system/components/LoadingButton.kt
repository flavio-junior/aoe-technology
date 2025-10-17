package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.jr.aoe.technology.design.system.forms.onBorder
import br.com.jr.aoe.technology.design.system.specifications.TypeFont
import br.com.jr.aoe.technology.design.system.theme.Themes

@Composable
fun LoadingButton(
    modifier: Modifier = Modifier,
    background: Color = Themes.colors.secondary,
    label: String,
    isEnabled: Boolean = false,
    onClick: () -> Unit = {}
) {
    var enabled: Boolean by remember { mutableStateOf(value = false) }
    enabled = isEnabled
    var listenerOnClick: Boolean by remember { mutableStateOf(value = false) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .onBorder(
                onClick = {
                    listenerOnClick = !enabled
                },
                spaceSize = Themes.size.spaceSize12,
                width = Themes.size.spaceSize0,
                color = Themes.colors.primary
            )
            .background(color = background)
            .padding(all = Themes.size.spaceSize18)
            .fillMaxWidth()
    ) {
        if (listenerOnClick) {
            onClick()
        }
        if (enabled) {
            listenerOnClick = false
            CircularProgressIndicator()
        } else {
            listenerOnClick = false
            Description(
                label = label,
                color = Themes.colors.lightText,
                typeFont = TypeFont.EXTRA_BOLD
            )
        }
    }
}
