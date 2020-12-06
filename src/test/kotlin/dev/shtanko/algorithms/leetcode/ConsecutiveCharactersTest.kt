package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class ConsecutiveCharactersTest<out T : ConsecutiveCharactersStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of("leetcode", 2),
                Arguments.of("abbcccddddeeeeedcba", 5),
                Arguments.of("triplepillooooow", 5),
                Arguments.of("hooraaaaaaaaaaay", 11),
                Arguments.of("tourist", 1),
                Arguments.of("", 0),
                Arguments.of("a", 1)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `consecutive characters test`(s: String, expected: Int) {
        val actual = strategy.perform(s)
        assertEquals(expected, actual)
    }
}

internal class MaxPower1Test : ConsecutiveCharactersTest<MaxPower1>(MaxPower1())
internal class MaxPower2Test : ConsecutiveCharactersTest<MaxPower2>(MaxPower2())
