package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class NextPermutationTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(1, 3, 2) to intArrayOf(1, 2, 3),
                intArrayOf(1, 2, 3) to intArrayOf(3, 2, 1),
                intArrayOf(1, 5, 1) to intArrayOf(1, 1, 5),
                intArrayOf(2, 1, 3) to intArrayOf(1, 3, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `next permutation test`(testCase: Pair<IntArray, IntArray>) {
        val (expected, arr) = testCase
        arr.nextPermutation()
        assertArrayEquals(expected, arr)
    }
}
