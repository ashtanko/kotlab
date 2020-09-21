package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

abstract class PermutationInStringStrategyTest<out T : StringPermutationStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        assertTrue(strategy.perform("ab", "eidbaooo"))
    }

    @Test
    fun `simple test 2`() {
        assertFalse(strategy.perform("ab", "eidboaoo"))
    }
}

class PermutationBruteForceTest : PermutationInStringStrategyTest<PermutationBruteForce>(PermutationBruteForce())

class PermutationSortingTest : PermutationInStringStrategyTest<PermutationSorting>(PermutationSorting())

class PermutationHashmapTest : PermutationInStringStrategyTest<PermutationHashmap>(PermutationHashmap())

class PermutationArrayTest : PermutationInStringStrategyTest<PermutationArray>(PermutationArray())

class PermutationSlidingWindowTest :
    PermutationInStringStrategyTest<PermutationSlidingWindow>(PermutationSlidingWindow())

class PermutationOptimizedSlidingWindowTest :
    PermutationInStringStrategyTest<PermutationOptimizedSlidingWindow>(PermutationOptimizedSlidingWindow())
