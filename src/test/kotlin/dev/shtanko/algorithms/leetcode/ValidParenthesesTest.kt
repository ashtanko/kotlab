package dev.shtanko.algorithms.leetcode

import java.util.TreeMap
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ValidParenthesesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, String>> {
            return listOf(
                true to "()",
                true to "()[]{}",
                false to "(]",
                false to "([)]",
                true to "{[]}"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is valid parentheses test`(testCase: Pair<Boolean, String>) {
        val (expected, str) = testCase
        val actual = str.isValidParentheses()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is valid parentheses mapping test`(testCase: Pair<Boolean, String>) {
        val (expected, s) = testCase
        val actual = ValidParentheses(TreeMap()).perform(s)
        assertEquals(expected, actual)
    }
}
