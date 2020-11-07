package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class NQueensIITest<out T : TotalNQueensStrategy>(private val strategy: T) {

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
    fun `simple test`(testCase: Pair<Int, Int>) {
        val actual = strategy.perform(testCase.first)
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}

class TotalNQueensStraightForwardTest : NQueensIITest<TotalNQueensStraightForward>(TotalNQueensStraightForward())
class TotalNQueensRecursiveTest : NQueensIITest<TotalNQueensRecursive>(TotalNQueensRecursive())
