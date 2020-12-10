package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class IsomorphicStringsTest {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> = listOf(
            "egg" to "add" to true,
            "foo" to "bar" to false,
            "paper" to "title" to true,
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `is isomorphic test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val (data, expected) = testCase
        val actual = data.isIsomorphic()
        assertEquals(expected, actual)
    }
}
