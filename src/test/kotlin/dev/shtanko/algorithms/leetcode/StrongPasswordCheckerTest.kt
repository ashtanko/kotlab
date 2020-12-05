package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class StrongPasswordCheckerTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, Int>> {
            return listOf(
                "" to 6,
                "123456" to 2,
                "qwerty" to 2,
                "password123456" to 1
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `strong password checker test`(testCase: Pair<String, Int>) {
        val (password, expected) = testCase
        val actual = strongPasswordChecker(password)
        assertEquals(expected, actual)
    }
}
