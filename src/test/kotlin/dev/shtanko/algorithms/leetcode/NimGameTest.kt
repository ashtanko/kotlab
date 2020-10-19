package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NimGameTest {

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
    fun `simple test`(testCase: Pair<Boolean, Int>) {
        val expected = testCase.first
        val n = testCase.second
        val actual = canWinNim(n)
        if (expected) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
