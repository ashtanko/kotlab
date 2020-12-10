package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DIStringMatchTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<IntArray, String>> {
            return listOf(
                intArrayOf(0, 4, 1, 3, 2) to "IDID",
                intArrayOf(0, 1, 2, 3) to "III",
                intArrayOf(3, 2, 0, 1) to "DDI",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `di string match test`(testCase: Pair<IntArray, String>) {
        val (expected, str) = testCase
        assertArrayEquals(expected, str.diStringMatch())
    }
}
