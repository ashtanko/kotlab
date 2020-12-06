package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class NumberOfStepsTest<out T : NumberOfStepsStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<Int, Int>> {
            return listOf(
                14 to 6,
                8 to 4,
                123 to 12
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `number of steps test`(testCase: Pair<Int, Int>) {
        val (n, expected) = testCase
        val actual = strategy.perform(n)
        assertEquals(expected, actual)
    }
}

internal class NumberOfStepsStraightForwardTest :
    NumberOfStepsTest<NumberOfStepsStraightForward>(NumberOfStepsStraightForward())

internal class NumberOfStepsBinaryTest : NumberOfStepsTest<NumberOfStepsBinary>(NumberOfStepsBinary())
