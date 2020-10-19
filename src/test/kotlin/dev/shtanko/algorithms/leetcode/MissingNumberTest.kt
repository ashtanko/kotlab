package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AbstractMissingNumberStrategyTest<out T : AbstractMissingNumberStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Int, IntArray>> {
            return listOf(
                2 to intArrayOf(3, 0, 1),
                8 to intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1),
                0 to intArrayOf(1, 2, 3),
                7 to intArrayOf(9, 6, 4, 2, 3, 5, 8, 0, 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    fun `missing number test`(testCase: Pair<Int, IntArray>) {
        val expected = testCase.first
        val arr = testCase.second
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

class MissingNumberSortingTest : AbstractMissingNumberStrategyTest<MissingNumberSorting>(MissingNumberSorting())

class MissingNumberHashSetTest : AbstractMissingNumberStrategyTest<MissingNumberHashSet>(MissingNumberHashSet())

class MissingNumberBitManipulationTest :
    AbstractMissingNumberStrategyTest<MissingNumberBitManipulation>(MissingNumberBitManipulation())

class MissingNumberGaussFormulaTest :
    AbstractMissingNumberStrategyTest<MissingNumberGaussFormula>(MissingNumberGaussFormula())
