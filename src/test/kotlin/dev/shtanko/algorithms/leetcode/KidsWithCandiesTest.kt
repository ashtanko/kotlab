package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class KidsWithCandiesTest<out T : KidsWithCandiesStrategy>(private val strategy: T) {

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
    internal fun `kids with candies test`(testCase: Pair<Pair<IntArray, Int>, BooleanArray>) {
        val (data, expected) = testCase
        val (candies, extraCandies) = data
        val actual = strategy.perform(candies, extraCandies)
        assertArrayEquals(expected, actual)
    }
}

internal class KidsWithCandiesStraightForwardTest :
    KidsWithCandiesTest<KidsWithCandiesStraightForward>(KidsWithCandiesStraightForward())

internal class KidsWithCandiesStreamTest : KidsWithCandiesTest<KidsWithCandiesStream>(KidsWithCandiesStream())
