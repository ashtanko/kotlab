package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ToLowerCaseTest {

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
    fun `simple test`(testCase: Pair<String, String>) {
        val expected = testCase.second
        val str = testCase.first
        val actual = toLowerCase(str)
        assertEquals(expected, actual)
    }
}
