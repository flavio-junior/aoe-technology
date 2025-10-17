package br.com.jr.aoe.technology.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.jr.aoe.technology.design.system.theme.MyTheme
import br.com.jr.aoe.technology.navigation.NavigationGraphic

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                NavigationGraphic()
            }
        }
    }
}
