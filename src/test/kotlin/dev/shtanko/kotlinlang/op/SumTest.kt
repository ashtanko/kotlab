package dev.shtanko.kotlinlang.op

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SumTest {

    @Test
    internal fun `sum test`() {
        val arr = intArrayOf(2, 2)
        assertEquals(4, arr.sum())
    }
}
