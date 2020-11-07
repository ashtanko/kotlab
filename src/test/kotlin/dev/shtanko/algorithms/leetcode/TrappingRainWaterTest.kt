package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class TrappingRainWaterTest<out T : RainWaterStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1) to 6,
                intArrayOf() to 0,
                intArrayOf(1) to 0,
                intArrayOf(0, 1) to 0,
                intArrayOf(0, 1, 2, 1, 0, 3, 2) to 3
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<IntArray, Int>) {
        val arr = testCase.first
        val actual = strategy.perform(arr)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

class RainWaterStraightForwardTest : TrappingRainWaterTest<RainWaterStraightForward>(RainWaterStraightForward())
class RainWaterStackTest : TrappingRainWaterTest<RainWaterStack>(RainWaterStack())
