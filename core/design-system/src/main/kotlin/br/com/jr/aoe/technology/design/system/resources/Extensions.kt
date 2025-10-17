package br.com.jr.aoe.technology.design.system.resources

fun validateEmail(
    email: String
): Boolean {
    val emailRegex = Regex(
        pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    )
    return emailRegex.matches(input = email)
}

fun validatePassword(
    password: String
): Boolean {
    val passwordRegex = Regex(pattern = "^(?=.*[A-Za-z])(?=.*\\d).+$")
    return passwordRegex.matches(input = password)
}

fun CharSequence.isBlankAndEmpty(): Boolean {
    return isBlank() && isEmpty()
}

fun CharSequence.isNotBlankAndEmpty(): Boolean {
    return isNotBlank() && isNotEmpty()
}
