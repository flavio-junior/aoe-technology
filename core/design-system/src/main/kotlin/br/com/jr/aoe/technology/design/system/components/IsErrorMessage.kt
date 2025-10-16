package br.com.jr.aoe.technology.design.system.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@Composable
fun IsErrorMessage(
    isError: Boolean,
    message: String? = null
) {
    if (isError && message?.isNotEmpty() == true) {
        InfoText(
            modifier = Modifier.fillMaxWidth(),
            label = message,
            textAlign = TextAlign.Start
        )
    }
}
