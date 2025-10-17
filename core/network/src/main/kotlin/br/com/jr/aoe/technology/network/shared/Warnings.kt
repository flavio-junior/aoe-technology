package br.com.jr.aoe.technology.network.shared

object Warnings {
    const val INVALID_EMAIL = "Este email é inválido!"
    const val INVALID_PASSWORD = "Adicione, pelo menos uma letra e um número!"
    const val PASSWORD_ERROR_SIZE = "Sua senha precisa ter, pelo menos 6 digitos!"
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