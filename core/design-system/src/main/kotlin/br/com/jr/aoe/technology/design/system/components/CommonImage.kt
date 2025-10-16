package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.resources.getIconResource

@Composable
fun CommonImage(
    modifier: Modifier = Modifier,
    iconName: IconName
) {
    Image(
        painter = getIconResource(iconName = iconName),
        contentDescription = null,
        modifier = modifier
    )
}
