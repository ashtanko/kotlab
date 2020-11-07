package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class UniqueOccurrencesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, IntArray>> {
            return listOf(
                true to intArrayOf(1, 2, 2, 1, 1, 3),
                false to intArrayOf(1, 2),
                true to intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `unique occurrences test`(testCase: Pair<Boolean, IntArray>) {
        val arr = testCase.second
        val actual = arr.uniqueOccurrences()
        val predicate = testCase.first
        if (predicate) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
