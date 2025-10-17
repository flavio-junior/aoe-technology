package br.com.jr.aoe.technology.navigation

import androidx.activity.ComponentActivity
import androidx.navigation.NavController

fun NavController.finishApp() = (context as? ComponentActivity)?.finish()
