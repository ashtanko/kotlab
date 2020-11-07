package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class RegularExpressionMatchingStrategyTest<out T : RegularExpressionMatchStrategy>(private val strategy: T) {

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
    fun `regular expression matching test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val actual = strategy.perform(testCase.first.first, testCase.first.second)
        if (testCase.second) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}

class RegularExpressionMatchRecursionTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchRecursion>(RegularExpressionMatchRecursion())

class RegularExpressionMatchDPTopDownTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPTopDown>(RegularExpressionMatchDPTopDown())

class RegularExpressionMatchDPBottomUpTest :
    RegularExpressionMatchingStrategyTest<RegularExpressionMatchDPBottomUp>(RegularExpressionMatchDPBottomUp())
