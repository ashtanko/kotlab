package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class WildcardMatchingTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> {
            return listOf(
                "aa" to "a" to false,
                "aa" to "*" to true,
                "cb" to "?a" to false,
                "adceb" to "*a*b" to true,
                "acdcb" to "a*c?b" to false
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `simple test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val (pair, expected) = testCase
        val actual = pair.isMatch()
        assertEquals(expected, actual)
    }
}
