package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class MaximumAverageSubArray1Test<out T : FindMaxAverageStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, Double>> {
            return listOf(
                intArrayOf(1, 12, -5, -6, 50, 3) to 4 to 12.75
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<IntArray, Int>, Double>) {
        val nums = testCase.first.first
        val k = testCase.first.second
        val actual = strategy.perform(nums, k)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

class FindMaxAverage1Test : MaximumAverageSubArray1Test<FindMaxAverage1>(FindMaxAverage1())
class FindMaxAverage2Test : MaximumAverageSubArray1Test<FindMaxAverage2>(FindMaxAverage2())
