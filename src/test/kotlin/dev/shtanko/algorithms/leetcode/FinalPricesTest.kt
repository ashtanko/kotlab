package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FinalPricesTest {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(8, 4, 6, 2, 3)
        assertArrayEquals(intArrayOf(4, 2, 4, 2, 3), arr.finalPrices())
    }
}
