package br.com.jr.aoe.technology.common.account.vo

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseVO(
    val id: String? = "",
    val customerName: String? = "",
    val accountNumber: String? = "",
    val branchNumber: String? = "",
    val checkingAccountBalance: String? = ""
)
