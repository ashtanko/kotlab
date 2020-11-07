package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

abstract class NumberOfStepsTest<out T : NumberOfStepsStrategy>(private val strategy: T) {

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
    fun `simple test`(testCase: Pair<Int, Int>) {
        val expected = testCase.second
        val actual = strategy.perform(testCase.first)
        assertEquals(expected, actual)
    }
}

class NumberOfStepsStraightForwardTest : NumberOfStepsTest<NumberOfStepsStraightForward>(NumberOfStepsStraightForward())
class NumberOfStepsBinaryTest : NumberOfStepsTest<NumberOfStepsBinary>(NumberOfStepsBinary())
