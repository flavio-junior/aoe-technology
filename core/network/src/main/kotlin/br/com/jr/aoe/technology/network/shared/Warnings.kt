package br.com.jr.aoe.technology.network.shared

object Warnings {
    const val CHECK_SIZE_PASSWORD = 8
    const val INVALID_EMAIL = "Este email é inválido!"
    const val INVALID_PASSWORD = "Senhas não coincidem!"
    const val PASSWORD_ERROR_SIZE = "Sua senha tem menos de 8 digitos!"
    const val NOT_BLANK_OR_EMPTY = "Preencha todos os campos!"
}


val enabledObserver =
    Observer(enabled = true, error = false, message = "")

val invalidEmail =
    Observer(enabled = false, error = true, message = Warnings.INVALID_EMAIL)

val invalidPassword =
    Observer(enabled = false, error = true, message = Warnings.INVALID_PASSWORD)

val passwordErrorSize =
    Observer(enabled = false, error = true, message = Warnings.PASSWORD_ERROR_SIZE)

val notBlankOrEmpty =
    Observer(enabled = false, error = true, message = Warnings.NOT_BLANK_OR_EMPTY)