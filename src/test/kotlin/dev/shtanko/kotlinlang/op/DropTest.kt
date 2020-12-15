package dev.shtanko.kotlinlang.op

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class DropTest {

    @Test
    internal fun `drop test`() {
        val list = 0.until(10).toList()
        val actual = list.drop(5)
        val expected = listOf(5, 6, 7, 8, 9)
        assertEquals(expected, actual)
    }

    @Test
    internal fun `drop last test`() {
        val list = 0.until(10).toList()
        val actual = list.dropLast(5)
        val expected = listOf(0, 1, 2, 3, 4)
        assertEquals(expected, actual)
    }
}
