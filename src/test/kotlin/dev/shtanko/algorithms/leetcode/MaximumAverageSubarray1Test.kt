package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.lang.Double.NaN

internal abstract class MaximumAverageSubArray1Test<out T : FindMaxAverageStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Double>> {
            return listOf(
                intArrayOf() to 0 to NaN,
                intArrayOf(1, 12, -5, -6, 50, 3) to 4 to 12.75,
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<Pair<IntArray, Int>, Double>) {
        val (data, expected) = testCase
        val (nums, k) = data
        val actual = strategy.perform(nums, k)
        assertEquals(expected, actual)
    }
}

internal class FindMaxAverage1Test : MaximumAverageSubArray1Test<FindMaxAverage1>(FindMaxAverage1())
internal class FindMaxAverage2Test : MaximumAverageSubArray1Test<FindMaxAverage2>(FindMaxAverage2())
