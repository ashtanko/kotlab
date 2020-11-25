package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.TreeMap

class ValidParenthesesTest {

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
    fun `is valid parentheses test`(testCase: Pair<Boolean, String>) {
        val actual = testCase.second.isValidParentheses()
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is valid parentheses mapping test`(testCase: Pair<Boolean, String>) {
        val s = testCase.second
        val actual = ValidParentheses(TreeMap()).perform(s)

        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
