package dev.shtanko.kotlinlang.op

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TakeTest {

    @Test
    internal fun `take test`() {
        val list = IntArray(100) { it * 10 }
        val expected = listOf(0, 10)
        val actual = list.take(2)
        assertEquals(expected, actual)
    }

    @Test
    internal fun `take last test`() {
        val list = IntArray(100) { it * 10 }
        val expected = listOf(980, 990)
        val actual = list.takeLast(2)
        assertEquals(expected, actual)
    }

    @Test
    internal fun `take last while test`() {
        val list = IntArray(100) { it * 10 }
        val expected = listOf(900, 910, 920, 930, 940, 950, 960, 970, 980, 990)
        val actual = list.takeLastWhile { it >= 900 }
        assertEquals(expected, actual)
    }
}
