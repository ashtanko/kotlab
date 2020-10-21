package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class RemoveOutermostParenthesesTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, String>> {
            return listOf(
                "(()())(())" to "()()()",
                "()()" to ""
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `remove outer parentheses test`(testCase: Pair<String, String>) {
        val expected = testCase.second
        val actual = testCase.first.removeOuterParentheses()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `remove outer parentheses 2 test`(testCase: Pair<String, String>) {
        val expected = testCase.second
        val actual = testCase.first.removeOuterParentheses2()
        assertEquals(expected, actual)
    }
}
