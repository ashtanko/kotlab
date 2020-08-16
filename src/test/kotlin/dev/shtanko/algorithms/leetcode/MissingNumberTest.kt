package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractMissingNumberStrategyTest<out T : AbstractMissingNumberStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        assertEquals(2, strategy.perform(intArrayOf(3, 0, 1)))
    }

    @Test
    fun `simple test 2`() {
        assertEquals(8, strategy.perform(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }

    @Test
    fun `no missing test`() {
        assertEquals(0, strategy.perform(intArrayOf(1, 2, 3)))
    }

    @Test
    fun `missing test`() {
        assertEquals(7, strategy.perform(intArrayOf(9, 6, 4, 2, 3, 5, 8, 0, 1)))
    }
}

class MissingNumberSortingTest : AbstractMissingNumberStrategyTest<MissingNumberSorting>(MissingNumberSorting())

class MissingNumberHashSetTest : AbstractMissingNumberStrategyTest<MissingNumberHashSet>(MissingNumberHashSet())

class MissingNumberBitManipulationTest :
    AbstractMissingNumberStrategyTest<MissingNumberBitManipulation>(MissingNumberBitManipulation())

class MissingNumberGaussFormulaTest :
    AbstractMissingNumberStrategyTest<MissingNumberGaussFormula>(MissingNumberGaussFormula())
