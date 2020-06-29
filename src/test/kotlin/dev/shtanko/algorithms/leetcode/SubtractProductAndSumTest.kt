package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubtractProductAndSumTest {

    @Test
    fun `simple test`() {
        assertEquals(15, 234.subtractProductAndSum())
    }

    @Test
    fun `simple test 2`() {
        assertEquals(21, 4421.subtractProductAndSum())
    }
}
