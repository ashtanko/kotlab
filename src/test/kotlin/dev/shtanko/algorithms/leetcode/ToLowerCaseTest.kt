package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ToLowerCaseTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, String>> {
            return listOf(
                "Hello" to "hello",
                "here" to "here",
                "LOVELY" to "lovely",
                "QWERTYUIOPASDFGHJKLZXCVBNM" to "qwertyuiopasdfghjklzxcvbnm"
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `to lower case test`(testCase: Pair<String, String>) {
        val (str, expected) = testCase
        val actual = toLowerCase(str)
        assertEquals(expected, actual)
    }
}
