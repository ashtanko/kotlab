package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal abstract class LongestValidParenthesesTest<out T : LongestValidParenthesesStrategy>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                "",
                0
            ),
            Arguments.of(
                "(()",
                2
            ),
            Arguments.of(
                ")()())",
                4
            )
        )
    }

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
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `longest valid parentheses brute force test`(s: String, expected: Int) {
        val actual = LongestValidParenthesesBruteForce().perform(s)
        assertEquals(expected, actual)
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
