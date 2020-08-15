package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class AbstractMaximumProductStrategyTest<out T : AbstractMaximumProductStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val products = intArrayOf(1, 2, 3)
        assertEquals(6, strategy.perform(products))
    }

    @Test
    fun `simple test 2`() {
        val products = intArrayOf(1, 2, 3, 4)
        assertEquals(24, strategy.perform(products))
    }

    @Test
    fun `simple test 3`() {
        val products = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(60, strategy.perform(products))
    }

    @Test
    fun `lost test`() {
        val products = intArrayOf(4, 8, 15, 16, 23, 42)
        assertEquals(15456, strategy.perform(products))
    }

    @Test
    fun `simple test 4`() {
        val products = intArrayOf(5, 4, 3, 1)
        assertEquals(60, strategy.perform(products))
    }

    @Test
    fun `random test`() {
        val products = intArrayOf(
            5, 89, 1, 234, 78, 4, 9, 66, 123, 6, 9, 0
        )
        assertEquals(2561598, strategy.perform(products))
    }
}

class MaximumProductBrutForceTest :
    AbstractMaximumProductStrategyTest<MaximumProductBrutForce>(MaximumProductBrutForce())

class MaximumProductSortingTest : AbstractMaximumProductStrategyTest<MaximumProductSorting>(MaximumProductSorting())

class MaximumProductSingleScanTest :
    AbstractMaximumProductStrategyTest<MaximumProductSingleScan>(MaximumProductSingleScan())
