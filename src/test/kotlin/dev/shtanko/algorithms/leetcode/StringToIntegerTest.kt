package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class StringToIntegerTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, Int>> {
            return listOf(
                "" to 0,
                "0" to 0,
                "4" to 4,
                "-3" to -3,
                "435" to 435
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `string to int test`(testCase: Pair<String, Int>) {
        val str = testCase.first
        val actual = str.atoi()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
