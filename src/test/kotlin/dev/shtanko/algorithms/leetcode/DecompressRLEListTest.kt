package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DecompressRLEListTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, IntArray>> {
            return listOf(
                intArrayOf(1, 2, 3, 4) to intArrayOf(2, 4, 4, 4),
                intArrayOf(1, 1, 2, 3) to intArrayOf(1, 3, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `decompress RLE list test`(testCase: Pair<IntArray, IntArray>) {
        val (arr, expected) = testCase
        val actual = arr.decompressRLEList()
        assertArrayEquals(expected, actual)
    }
}
