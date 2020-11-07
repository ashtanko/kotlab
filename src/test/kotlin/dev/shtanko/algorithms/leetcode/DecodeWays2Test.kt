package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class AbstractDecodeWays2StrategyTest<out T : DecodeWays2Strategy>(private val strategy: DecodeWays2Strategy) {

    companion object {

        @JvmStatic
        private fun provideNumbers(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("*", 9),
                Arguments.of("1*", 18)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    fun `simple test`(str: String, expected: Int) {
        val actual = strategy.perform(str)
        assertEquals(expected, actual)
    }
}

class DecodeWays2RecursionWithMemoizationTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2RecursionWithMemoization>(DecodeWays2RecursionWithMemoization())

class DecodeWays2DynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2DynamicProgramming>(DecodeWays2DynamicProgramming())

class DecodeWays2ConstantSpaceDynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2ConstantSpaceDynamicProgramming>(
        DecodeWays2ConstantSpaceDynamicProgramming()
    )
