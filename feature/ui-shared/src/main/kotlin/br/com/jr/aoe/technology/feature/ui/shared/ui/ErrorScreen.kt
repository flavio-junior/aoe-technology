package br.com.jr.aoe.technology.feature.ui.shared.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.jr.aoe.technology.design.system.components.LoadingButton
import br.com.jr.aoe.technology.design.system.components.Title
import br.com.jr.aoe.technology.design.system.theme.Themes
import br.com.jr.aoe.technology.feature.ui.shared.R

@Composable
fun ErrorScreen(
    tryAgain: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = Themes.size.spaceSize16),
        verticalArrangement = Arrangement.Center
    ) {
        Title(label = stringResource(id = R.string.internal_error))
        Spacer(modifier = Modifier.height(height = Themes.size.spaceSize32))
        LoadingButton(
            label = stringResource(id = R.string.try_again),
            onClick = tryAgain
        )
    }
}
