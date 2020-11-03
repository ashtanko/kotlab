package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class AbstractRotateArrayStrategyTest<out T : AbstractRotateArrayStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                Pair(Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3), intArrayOf(5, 6, 7, 1, 2, 3, 4)),
                Pair(Pair(intArrayOf(-1, -100, 3, 99), 2), intArrayOf(3, 99, -1, -100))
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `rotate array test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val arr = testCase.first.first
        val k = testCase.first.second
        strategy.perform(arr, k)
        val expected = testCase.second
        assertArrayEquals(expected, arr)
    }
}

class RotateArrayBruteForceTest : AbstractRotateArrayStrategyTest<RotateArrayBruteForce>(RotateArrayBruteForce())

class RotateArrayUsingExtraArrayTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingExtraArray>(RotateArrayUsingExtraArray())

class RotateArrayUsingCyclicReplacementsTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingCyclicReplacements>(RotateArrayUsingCyclicReplacements())

class RotateArrayUsingReverseTest :
    AbstractRotateArrayStrategyTest<RotateArrayUsingReverse>(RotateArrayUsingReverse())
