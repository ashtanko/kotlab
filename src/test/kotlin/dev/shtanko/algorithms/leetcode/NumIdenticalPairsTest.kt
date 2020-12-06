package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AbstractNumIdenticalPairsTest<T : AbstractNumIdenticalPairs>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(1, 2, 3, 1, 1, 3) to 4,
                intArrayOf(1, 1, 1, 1) to 6,
                intArrayOf(1, 2, 3) to 0
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `abstract num identical pairs test`(testCase: Pair<IntArray, Int>) {
        val (arr, expected) = testCase
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class NumIdenticalPairsNaiveTest :
    AbstractNumIdenticalPairsTest<NumIdenticalPairsNaive>(NumIdenticalPairsNaive())

internal class NumIdenticalPairsMapTest : AbstractNumIdenticalPairsTest<NumIdenticalPairsMap>(NumIdenticalPairsMap())

internal class NumIdenticalPairsSortTest : AbstractNumIdenticalPairsTest<NumIdenticalPairsSort>(NumIdenticalPairsSort())
