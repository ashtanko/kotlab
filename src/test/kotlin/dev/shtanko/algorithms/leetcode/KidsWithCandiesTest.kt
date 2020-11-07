package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class KidsWithCandiesTest<out T : KidsWithCandiesStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, BooleanArray>> {
            return listOf(
                intArrayOf(2, 3, 5, 1, 3) to 3 to booleanArrayOf(true, true, true, false, true),
                intArrayOf(4, 2, 1, 1, 2) to 1 to booleanArrayOf(true, false, false, false, false),
                intArrayOf(12, 1, 12) to 10 to booleanArrayOf(true, false, true)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `simple test`(testCase: Pair<Pair<IntArray, Int>, BooleanArray>) {
        val candies = testCase.first.first
        val extraCandies = testCase.first.second
        val actual = strategy.perform(candies, extraCandies)
        val expected = testCase.second
        assertArrayEquals(expected, actual)
    }
}

class KidsWithCandiesStraightForwardTest :
    KidsWithCandiesTest<KidsWithCandiesStraightForward>(KidsWithCandiesStraightForward())

class KidsWithCandiesStreamTest : KidsWithCandiesTest<KidsWithCandiesStream>(KidsWithCandiesStream())
