package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class LongestValidParenthesesTest<out T : LongestValidParenthesesStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        fun dataProvider() = listOf(
            "" to 0,
            "(()" to 2,
            ")()())" to 4,
            "((())))()())))(((()()(())))((()(())()((()))())())())()()" to 42
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `longest valid parentheses test`(testCase: Pair<String, Int>) {
        val (s, expected) = testCase
        val actual = strategy.perform(s)
        assertEquals(expected, actual)
    }
}

// Do not run on CI, time limit expended
// class LongestValidParenthesesBruteForceTest :
//    LongestValidParenthesesTest<LongestValidParenthesesBruteForce>(LongestValidParenthesesBruteForce())

internal class LongestValidParenthesesDPTest :
    LongestValidParenthesesTest<LongestValidParenthesesDP>(LongestValidParenthesesDP())

internal class LongestValidParenthesesStackTest :
    LongestValidParenthesesTest<LongestValidParenthesesStack>(LongestValidParenthesesStack())

internal class LongestValidParenthesesWithoutExtraSpaceTest :
    LongestValidParenthesesTest<LongestValidParenthesesWithoutExtraSpace>(LongestValidParenthesesWithoutExtraSpace())
