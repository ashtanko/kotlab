package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SelfDividingNumbersTest {

    @Test
    fun `simple test`() {
        val numbers = 1 to 22
        val actual = numbers.selfDividingNumbers()
        val expected = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22)
        assertEquals(expected, actual)
    }
}
