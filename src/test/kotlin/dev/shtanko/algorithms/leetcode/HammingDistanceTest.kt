package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HammingDistanceTest {

    @Test
    fun `simple test`() {
        val actual = hammingDistance(1, 4)
        val expected = 2
        assertEquals(expected, actual)
    }
}
