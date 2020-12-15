package dev.shtanko.kotlinlang.op

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FlatMapTest {

    @Test
    internal fun `flat map test`() {
        val list = listOf(4)
        val actual = list.flatMap {
            it.rangeTo(it * 2).toList()
        }
        val expected = listOf(4, 5, 6, 7, 8)
        assertEquals(expected, actual)
    }

    @Test
    internal fun `flat map test 2`() {
        val list = listOf(4, 8)
        val actual = list.flatMap {
            listOf(it * 2)
        }
        val expected = listOf(8, 16)
        assertEquals(expected, actual)
    }
}
