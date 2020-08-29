package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

abstract class AbstractRotateArrayStrategyTest<out T : AbstractRotateArrayStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 3
        strategy.perform(arr, k)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), arr)
    }

    @Test
    fun `simple test 2`() {
        val arr = intArrayOf(-1, -100, 3, 99)
        val k = 2
        strategy.perform(arr, k)
        assertArrayEquals(intArrayOf(3, 99, -1, -100), arr)
    }
}

class RotateArrayBruteForceTest : AbstractRotateArrayStrategyTest<RotateArrayBruteForce>(RotateArrayBruteForce())

class RotateArrayUsingExtraArrayTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingExtraArray>(RotateArrayUsingExtraArray())

class RotateArrayUsingCyclicReplacementsTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingCyclicReplacements>(RotateArrayUsingCyclicReplacements())

class RotateArrayUsingReverseTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingReverse>(RotateArrayUsingReverse())
