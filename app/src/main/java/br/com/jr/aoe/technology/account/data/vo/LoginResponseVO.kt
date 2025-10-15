package br.com.jr.aoe.technology.account.data.vo

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseVO(
    val id: Long? = 0,
    val customerName: String? = "",
    val accountNumber: String? = "",
    val branchNumber: Long? = 0,
    val checkingAccountBalance: Int? = 0,
)
