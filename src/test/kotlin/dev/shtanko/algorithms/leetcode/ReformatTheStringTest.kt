package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class ReformatTheStringTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<String, String>> {
            return listOf(
                "a0b1c2" to "a0b1c2",
                "" to "leetcode",
                "" to "1229857369",
                "c2o0v1i9d" to "covid2019",
                "1a2b3" to "ab123",
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `reformat string test`(testCase: Pair<String, String>) {
        val (expected, str) = testCase
        val actual = str.reformat()
        assertEquals(expected, actual)
    }
}
