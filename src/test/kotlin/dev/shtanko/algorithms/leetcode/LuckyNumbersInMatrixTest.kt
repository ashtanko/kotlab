package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AbstractLuckyNumbersStrategyTest<out T : AbstractLuckyNumbersStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Array<IntArray>, List<Int>>> {
            return listOf(
                arrayOf(
                    intArrayOf(3, 7, 8),
                    intArrayOf(9, 11, 13),
                    intArrayOf(15, 16, 17)
                ) to listOf(15),
                arrayOf(
                    intArrayOf(1, 10, 4, 2),
                    intArrayOf(9, 3, 8, 7),
                    intArrayOf(15, 16, 17, 12)
                ) to listOf(12),
                arrayOf(
                    intArrayOf(7, 8),
                    intArrayOf(1, 2)
                ) to listOf(7)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<Array<IntArray>, List<Int>>) {
        val (matrix, expected) = testCase
        assertEquals(expected, strategy.perform(matrix))
    }
}

internal class LuckyNumbersTest : AbstractLuckyNumbersStrategyTest<LuckyNumbers>(LuckyNumbers())

internal class LuckyNumbersSetTest : AbstractLuckyNumbersStrategyTest<LuckyNumbersSet>(LuckyNumbersSet())
