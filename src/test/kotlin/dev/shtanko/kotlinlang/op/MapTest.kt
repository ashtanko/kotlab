package dev.shtanko.kotlinlang.op

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MapTest {

    @Test
    fun `map test`() {
        val list = listOf(4, 8, 15, 16, 23, 42)
        val actual = list.map {
            "$it"
        }
        val expected = listOf("4", "8", "15", "16", "23", "42")
        assertEquals(expected, actual)
    }
}
