package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class NimGameTest {

    companion object {
        @JvmStatic
        fun casesProvider(): List<Pair<Boolean, Int>> {
            return listOf(
                false to 4,
                true to 1,
                true to 2
            )
        }
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    internal fun `nim game test`(testCase: Pair<Boolean, Int>) {
        val (expected, n) = testCase
        val actual = canWinNim(n)
        assertEquals(expected, actual)
    }
}
