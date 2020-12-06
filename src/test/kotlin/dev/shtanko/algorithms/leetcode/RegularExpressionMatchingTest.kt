package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class RegularExpressionMatchingStrategyTest<out T : RegularExpressionMatchStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> {
            return listOf(
                "aa" to "a" to false,
                "aa" to "a*" to true,
                "ab" to ".*" to true,
                "aab" to "c*a*b" to true,
                "mississippi" to "mis*is*p*." to false
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `regular expression matching test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val (data, expected) = testCase
        val (text, pattern) = data
        val actual = strategy.perform(text = text, pattern = pattern)
        assertEquals(expected, actual)
    }
}

internal class RegularExpressionMatchRecursionTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchRecursion>(RegularExpressionMatchRecursion())

internal class RegularExpressionMatchDPTopDownTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPTopDown>(RegularExpressionMatchDPTopDown())

internal class RegularExpressionMatchDPBottomUpTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPBottomUp>(RegularExpressionMatchDPBottomUp())
