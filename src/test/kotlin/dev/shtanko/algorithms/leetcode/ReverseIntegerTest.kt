package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ReverseIntegerTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                123 to 321,
                -123 to -321,
                0 to 0
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `reversed number test`(testCase: Pair<Int, Int>) {
        val actual = testCase.first.reversed()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
