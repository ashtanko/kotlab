package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class DivisorGameTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, Int>> {
            return listOf(
                true to 2,
                false to 3,
                true to 48,
                true to 1000 // or Int.MAX_VALUE
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `divisor game test`(testCase: Pair<Boolean, Int>) {
        val actual = testCase.second.divisorGame()
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `divisor game naive test`(testCase: Pair<Boolean, Int>) {
        val actual = testCase.second.divisorGameNaive()
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `divisor game brute force test`(testCase: Pair<Boolean, Int>) {
        val actual = testCase.second.divisorGameBruteForce()
        if (testCase.first) {
            assertTrue(actual)
        } else {
            assertFalse(actual)
        }
    }
}
