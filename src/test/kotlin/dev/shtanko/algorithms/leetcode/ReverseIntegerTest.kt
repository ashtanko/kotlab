package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseIntegerTest {

    @Test
    fun `simple test`() {
        val actual = 123.reversed()
        assertEquals(321, actual)
    }
}
