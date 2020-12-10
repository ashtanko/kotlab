package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class IsSubsequenceTest {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> = listOf(
            "abc" to "ahbgdc" to true,
            "axc" to "ahbgdc" to false,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is subsequence test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val (data, expected) = testCase
        val (s, t) = data
        val actual = isSubsequence(s, t)
        assertEquals(expected, actual)
    }
}
