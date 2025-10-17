package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import br.com.jr.aoe.technology.design.system.factory.IconName
import br.com.jr.aoe.technology.design.system.forms.onBorder
import br.com.jr.aoe.technology.design.system.resources.getIconResource
import br.com.jr.aoe.technology.design.system.theme.Themes

@Composable
fun CommonImage(
    modifier: Modifier = Modifier,
    iconName: IconName
) {
    Image(
        painter = getIconResource(iconName = iconName),
        contentDescription = null,
        modifier = modifier
            .onBorder(
                spaceSize = Themes.size.spaceSize12,
                width = Themes.size.spaceSize0,
                color = Themes.colors.primary
            )
            .height(height = Themes.size.spaceSize256)
            .fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}
