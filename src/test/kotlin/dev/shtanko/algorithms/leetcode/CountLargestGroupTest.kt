package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CountLargestGroupTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                4 to 13,
                2 to 2,
                6 to 15,
                5 to 24
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `count largest group test`(testCase: Pair<Int, Int>) {
        val expected = testCase.first
        val n = testCase.second
        assertEquals(expected, n.countLargestGroup())
    }
}
