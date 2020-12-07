package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AbstractDecodeWays2StrategyTest<out T : DecodeWays2Strategy>(private val strategy: DecodeWays2Strategy) {

    companion object {

        @JvmStatic
        private fun provideNumbers(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("", 0),
                Arguments.of("0", 0),
                Arguments.of("1", 1),
                Arguments.of("2", 1),
                Arguments.of("4", 1),
                Arguments.of("7", 1),
                Arguments.of("10", 1),
                Arguments.of("11", 2),
                Arguments.of("*", 9),
                Arguments.of("1*", 18)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideNumbers")
    internal fun `simple test`(str: String, expected: Int) {
        val actual = strategy.perform(str)
        assertEquals(expected, actual)
    }
}

internal class DecodeWays2RecursionWithMemoizationTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2RecursionWithMemoization>(DecodeWays2RecursionWithMemoization())

internal class DecodeWays2DynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2DynamicProgramming>(DecodeWays2DynamicProgramming())

internal class DecodeWays2ConstantSpaceDynamicProgrammingTest :
    AbstractDecodeWays2StrategyTest<DecodeWays2ConstantSpaceDynamicProgramming>(
        DecodeWays2ConstantSpaceDynamicProgramming()
    )
