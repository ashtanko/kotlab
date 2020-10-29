package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AbstractRobberTest<out T : AbstractRobberStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, Int>> {
            return listOf(
                intArrayOf(1, 2, 3, 1) to 4,
                intArrayOf(2, 7, 9, 3, 1) to 12,
                intArrayOf(4, 8, 15, 16, 23, 42) to 66,
                intArrayOf(1, 1, 1, 1, 1, 1) to 3,
                intArrayOf(1, 0, 1, 0, 1, 0, 1) to 4
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `robber test`(testCase: Pair<IntArray, Int>) {
        val arr = testCase.first
        val expected = testCase.second
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

class RecursiveRobberTest : AbstractRobberTest<RecursiveRobber>(RecursiveRobber())

class RecursiveRobberMemoTest : AbstractRobberTest<RecursiveRobberMemo>(RecursiveRobberMemo())

class IterativeRobberMemoTest : AbstractRobberTest<IterativeRobberMemo>(IterativeRobberMemo())

class IterativeRobberTest : AbstractRobberTest<IterativeRobber>(IterativeRobber())
