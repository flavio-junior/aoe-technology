package br.com.jr.aoe.technology.feature.account.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import br.com.jr.aoe.technology.design.system.components.Description
import br.com.jr.aoe.technology.design.system.components.Header
import br.com.jr.aoe.technology.design.system.components.InfoText
import br.com.jr.aoe.technology.design.system.components.SubTitle
import br.com.jr.aoe.technology.design.system.components.Title
import br.com.jr.aoe.technology.feature.account.R

@Composable
fun SignInScreen() {
    Column {
        Header(label = stringResource(id = R.string.sign_in))
        Title(label = "Teste")
        SubTitle(label = "Teste")
        Description(label = "Teste")
        InfoText(label = "Text")
    }
}
