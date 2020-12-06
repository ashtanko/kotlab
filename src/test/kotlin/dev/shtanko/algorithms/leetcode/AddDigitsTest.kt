package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class AddDigitsTest<out T : AddDigitsStrategy>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(38, 2)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `add digits test`(digits: Int, expected: Int) {
        val actual = strategy.perform(digits)
        assertEquals(expected, actual)
    }
}

internal class AddDigitsStraightForwardTest : AddDigitsTest<AddDigitsStraightForward>(AddDigitsStraightForward())
internal class AddDigitsMathTest : AddDigitsTest<AddDigitsMath>(AddDigitsMath())
