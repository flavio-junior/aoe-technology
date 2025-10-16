package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.forms.onClickable
import br.com.jr.aoe.technology.design.system.resources.getIconResource
import br.com.jr.aoe.technology.design.system.theme.Themes

@Composable
fun IconDefault(
    iconName: IconName,
    onClick: () -> Unit = {}
) {
    Icon(
        painter = getIconResource(iconName = iconName),
        contentDescription = null,
        modifier = Modifier
            .onClickable(onClick = onClick)
            .size(size = Themes.size.spaceSize32)
    )
}
