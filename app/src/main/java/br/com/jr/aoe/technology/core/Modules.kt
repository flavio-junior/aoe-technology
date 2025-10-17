package br.com.jr.aoe.technology.core

import br.com.jr.aoe.technology.feature.account.di.accountModule
import br.com.jr.aoe.technology.feature.payment.di.paymentModule
import br.com.jr.aoe.technology.network.di.networkModule

val modules = listOf(
    accountModule,
    networkModule,
    paymentModule
)
