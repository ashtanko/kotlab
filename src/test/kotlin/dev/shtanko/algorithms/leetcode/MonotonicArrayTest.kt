package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class MonotonicArrayTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Boolean, IntArray>> {
            return listOf(
                true to intArrayOf(1, 2, 2, 3),
                true to intArrayOf(6, 5, 4, 4),
                false to intArrayOf(1, 3, 2),
                true to intArrayOf(1, 2, 4, 5),
                true to intArrayOf(1, 1, 1),
                true to intArrayOf(1, 2, 5),
                false to intArrayOf(1, 5, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `is monotonic test`(testCase: Pair<Boolean, IntArray>) {
        val checkTrue = testCase.first
        val arr = testCase.second
        val actual = arr.isMonotonic()
        if (checkTrue) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
