package br.com.jr.aoe.technology.design.system.resources

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ExtensionsTest {

    @Test
    fun validateEmailGivenGetInvalidEmailReturnsFalse() {
        assertEquals(false, validateEmail(email = "test"))
    }

    @Test
    fun validateEmailGivenGetValidEmailReturnsTrue() {
        assertEquals(true, validateEmail(email = "test@example.com"))
    }

    @Test
    fun validateEmailGivenGetEmptyStringReturnsFalse() {
        assertEquals(false, validateEmail(email = ""))
    }

    @Test
    fun validateEmailGivenGetEmailWithoutDomainReturnsFalse() {
        assertEquals(false, validateEmail(email = "test@example"))
    }

    @Test
    fun validatePasswordGivenGetInvalidPasswordReturnsFalse() {
        assertEquals(false, validateEmail(email = "admsrdfdk"))
    }

    @Test
    fun validatePasswordGivenGetValidPasswordReturnsTrue() {
        assertEquals(true, validatePassword(password = "admin1234"))
    }

    @Test
    fun validateIsBlankAndEmptyGivenIsBlankAndEmptyReturnsFalse() {
        assertEquals(true, "".isBlankAndEmpty())
    }

    @Test
    fun validateIsBlankAndEmptyGivenIsBlankAndEmptyReturnsTrue() {
        assertEquals(false, "john".isBlankAndEmpty())
    }

    @Test
    fun validateIsNotBlankAndEmptyGivenIsNotBlankAndEmptyReturnsFalse() {
        assertEquals(false, "".isNotBlankAndEmpty())
    }

    @Test
    fun validateIsNotBlankAndEmptyGivenIsNotBlankAndEmptyReturnsTrue() {
        assertEquals(true, "john".isNotBlankAndEmpty())
    }
}
