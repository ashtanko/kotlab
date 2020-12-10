package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class DivisorGameTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Boolean, Int>> {
            return listOf(
                true to 2,
                false to 3,
                true to 48,
                true to 1000, // or Int.MAX_VALUE
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `divisor game test`(testCase: Pair<Boolean, Int>) {
        val (expected, num) = testCase
        val actual = num.divisorGame()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `divisor game naive test`(testCase: Pair<Boolean, Int>) {
        val (expected, num) = testCase
        val actual = num.divisorGameNaive()
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `divisor game brute force test`(testCase: Pair<Boolean, Int>) {
        val (expected, num) = testCase
        val actual = num.divisorGameBruteForce()
        assertEquals(expected, actual)
    }
}
