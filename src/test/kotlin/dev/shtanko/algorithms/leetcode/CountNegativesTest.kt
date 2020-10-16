package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AbstractCountNegativesTest<out T : AbstractCountNegativesStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Array<IntArray>>> {
            return listOf(
                8 to arrayOf(
                    intArrayOf(4, 3, 2, -1),
                    intArrayOf(3, 2, 1, -1),
                    intArrayOf(1, 1, -1, -2),
                    intArrayOf(-1, -1, -2, -3)
                ),
                0 to arrayOf(
                    intArrayOf(3, 2),
                    intArrayOf(1, 0)
                ),
                3 to arrayOf(
                    intArrayOf(1, -1),
                    intArrayOf(-1, -1)
                ),
                1 to arrayOf(
                    intArrayOf(-1)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `count negatives test`(testCase: Pair<Int, Array<IntArray>>) {
        val grid = testCase.second
        val expected = testCase.first
        val actual = strategy.perform(grid)
        assertEquals(expected, actual)
    }
}

class SimpleCountNegativesTest : AbstractCountNegativesTest<SimpleCountNegatives>(SimpleCountNegatives())

class CountNegativesTwoPointersTest : AbstractCountNegativesTest<CountNegativesTwoPointers>(CountNegativesTwoPointers())

class CountNegativesBinaryTest : AbstractCountNegativesTest<CountNegativesBinary>(CountNegativesBinary())
