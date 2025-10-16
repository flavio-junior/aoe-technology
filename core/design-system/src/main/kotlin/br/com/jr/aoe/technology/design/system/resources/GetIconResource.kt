package br.com.jr.aoe.technology.design.system.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.com.jr.aoe.technology.design.system.R
import br.com.jr.aoe.technology.design.system.factory.IconName

@Composable
fun getIconResource(
    iconName: IconName
) = when (iconName) {
    IconName.ARROW_BACK -> painterResource(id = R.drawable.arrow_back)
    IconName.LOCK -> painterResource(id = R.drawable.lock)
    IconName.MAIL -> painterResource(id = R.drawable.mail)
    IconName.VISIBILITY -> painterResource(id = R.drawable.visibility)
    IconName.VISIBILITY_OFF -> painterResource(id = R.drawable.visibility_off)
}
