package dev.shtanko.kotlinlang.op

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZipTest {

    @Test
    fun `zip names and ages test`() {
        val names = listOf("Sara", "Jake", "Nick", "John")
        val ages = listOf(4, 20, 15, 22)
        val expected = listOf(
            "Sara" to 4,
            "Jake" to 20,
            "Nick" to 15,
            "John" to 22
        )
        val actual = names.zip(ages)
        assertEquals(expected, actual)
    }
}
