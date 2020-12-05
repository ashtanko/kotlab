package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class UniqueOccurrencesTest {

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
    internal fun `unique occurrences test`(testCase: Pair<Boolean, IntArray>) {
        val (expected, arr) = testCase
        val actual = arr.uniqueOccurrences()
        assertEquals(expected, actual)
    }
}
