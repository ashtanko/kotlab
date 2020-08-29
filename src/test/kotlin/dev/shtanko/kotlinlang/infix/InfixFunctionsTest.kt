package dev.shtanko.kotlinlang.infix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InfixFunctionsTest {

    @Test
    fun `test colours`() {
        val color = 0x123456
        val red = color and 0xff0000 shr 16
        assertEquals(0x12, red)
    }

    @Test
    fun `test new assertions`() {
        val result = Assertion(5)
        result isEqualTo 5
        result isDifferentFrom 6
    }

    @Test
    fun `test new string method`() {
        infix fun String.substringMatches(r: Regex): List<String> {
            return r.findAll(this)
                .map { it.value }
                .toList()
        }

        val matches = "a bc def" substringMatches ".*? ".toRegex()
        assertEquals(listOf("a ", "bc "), matches)
    }
}
