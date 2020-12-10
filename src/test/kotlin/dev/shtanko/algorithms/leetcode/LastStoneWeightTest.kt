package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class LastStoneWeightTest<out T : LastStoneWeightStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(2, 7, 4, 1, 8, 1) to 1,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `last stone weight test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class LastStoneWeightSortTest : LastStoneWeightTest<LastStoneWeightSort>(LastStoneWeightSort())
internal class LastStoneWeightQueueTest : LastStoneWeightTest<LastStoneWeightQueue>(LastStoneWeightQueue())
