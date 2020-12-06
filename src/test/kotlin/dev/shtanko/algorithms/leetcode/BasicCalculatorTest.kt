package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal abstract class BasicCalculatorTest<out T : CalculationStrategy>(private val strategy: T) {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                "1 + 1" to 2,
                " 2-1 + 2 " to 3,
                "(1+(4+5+2)-3)+(6+8)" to 23,
                "2   +2" to 4
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `calculator test`(testCase: Pair<String, Int>) {
        val (s, expected) = testCase
        val actual = strategy.calculate(s)
        assertEquals(expected, actual)
    }
}

internal class StackAndStringReversalTest : BasicCalculatorTest<StackAndStringReversal>(StackAndStringReversal())

internal class StackAndNoStringReversalTest : BasicCalculatorTest<StackAndNoStringReversal>(StackAndNoStringReversal())
