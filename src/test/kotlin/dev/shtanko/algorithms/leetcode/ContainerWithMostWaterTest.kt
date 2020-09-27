package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

abstract class ContainerWithMostWaterStrategyTest<out T : ContainerWithMostWaterStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        assertEquals(49, strategy.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }
}

class ContainerWithMostWaterBruteForceTest :
    ContainerWithMostWaterStrategyTest<ContainerWithMostWaterBruteForce>(ContainerWithMostWaterBruteForce())

class ContainerWithMostWaterTwoPointerTest :
    ContainerWithMostWaterStrategyTest<ContainerWithMostWaterTwoPointer>(ContainerWithMostWaterTwoPointer())
