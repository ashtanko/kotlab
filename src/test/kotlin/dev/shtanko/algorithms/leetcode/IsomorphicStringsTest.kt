package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class IsomorphicStringsTest {

    companion object {

        @JvmStatic
        fun dataProvider(): List<Pair<Pair<String, String>, Boolean>> = listOf(
            "egg" to "add" to true,
            "foo" to "bar" to false,
            "paper" to "title" to true
        )
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `is isomorphic test`(testCase: Pair<Pair<String, String>, Boolean>) {
        val actual = testCase.first.isIsomorphic()
        val expected = testCase.second
        assertEquals(expected, actual)
    }
}
