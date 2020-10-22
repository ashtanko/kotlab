package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ValidNumberTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, String>> {
            return listOf(
                true to "0",
                true to " 0.1 ",
                false to "abc",
                false to "1 a",
                true to "2e10",
                true to " -90e3   ",
                false to " 1e",
                false to "e3",
                true to " 6e-1",
                false to " 99e2.5 ",
                true to "53.5e93",
                false to " --6 ",
                false to "-+3",
                false to "95a54e53",
                true to "-1"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is number using regex test`(testCase: Pair<Boolean, String>) {
        val actual = testCase.second.isNumberRegex()
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is number test`(testCase: Pair<Boolean, String>) {
        val actual = testCase.second.isNumber()
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
