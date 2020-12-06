package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class NQueensIITest<out T : TotalNQueensStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                4 to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `n queens 2 test`(testCase: Pair<Int, Int>) {
        val (n, expected) = testCase
        val actual = strategy.perform(n)
        assertEquals(expected, actual)
    }
}

internal class TotalNQueensStraightForwardTest :
    NQueensIITest<TotalNQueensStraightForward>(TotalNQueensStraightForward())

internal class TotalNQueensRecursiveTest : NQueensIITest<TotalNQueensRecursive>(TotalNQueensRecursive())
