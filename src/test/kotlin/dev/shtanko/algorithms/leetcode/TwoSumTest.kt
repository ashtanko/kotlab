package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class TwoSumTest<out T : TwoSumStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<IntArray, Int>, IntArray>> {
            return listOf(
                intArrayOf(4, 8, 15, 16, 23) to 9 to intArrayOf(),
                intArrayOf(4, 8, 15, 16, 23) to 12 to intArrayOf(0, 1),
                intArrayOf(4, 8, 15, 16, 23) to 39 to intArrayOf(3, 4)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `two sum test`(testCase: Pair<Pair<IntArray, Int>, IntArray>) {
        val array = testCase.first.first
        val target = testCase.first.second
        val actual = strategy.perform(array, target)
        val expected = testCase.second
        assertArrayEquals(expected, actual)
    }
}

class TwoSumBruteForceTest : TwoSumTest<TwoSumBruteForce>(TwoSumBruteForce())
class TwoSumTwoPassHashTableTest : TwoSumTest<TwoSumTwoPassHashTable>(TwoSumTwoPassHashTable())
class TwoSumOnePassHashTableTest : TwoSumTest<TwoSumOnePassHashTable>(TwoSumOnePassHashTable())
