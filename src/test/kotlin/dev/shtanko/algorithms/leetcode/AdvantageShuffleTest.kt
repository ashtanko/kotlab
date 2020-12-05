package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class AdvantageShuffleTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Triple<IntArray, IntArray, IntArray>> {
            return listOf(
                Triple(intArrayOf(), intArrayOf(), intArrayOf()),
                Triple(intArrayOf(2, 7, 11, 15), intArrayOf(1, 10, 4, 11), intArrayOf(2, 11, 7, 15)),
                Triple(intArrayOf(12, 24, 8, 32), intArrayOf(13, 25, 32, 11), intArrayOf(24, 32, 8, 12))
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(data: Triple<IntArray, IntArray, IntArray>) {
        data.run {
            val (a, b, expected) = data
            val actual = advantageCount(a, b)
            assertArrayEquals(expected, actual)
        }
    }
}
