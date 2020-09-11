package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class SuperEggDropStrategyTest<out T : SuperEggDropStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        assertEquals(3, strategy.perform(2, 6))
    }

    @Test
    fun `simple test 2`() {
        assertEquals(4, strategy.perform(3, 14))
    }
}

class SuperEggDropDPBinarySearchTest :
    SuperEggDropStrategyTest<SuperEggDropDPBinarySearch>(SuperEggDropDPBinarySearch())

class SuperEggDropDPOptimalityCriterionTest :
    SuperEggDropStrategyTest<SuperEggDropDPOptimalityCriterion>(SuperEggDropDPOptimalityCriterion())

class SuperEggDropMathematicalTest : SuperEggDropStrategyTest<SuperEggDropMathematical>(SuperEggDropMathematical())
