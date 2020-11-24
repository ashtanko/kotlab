package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

class MinimumCostToCutStickTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4, 5),
                7,
                16
            ),
            Arguments.of(
                intArrayOf(5, 6, 1, 4, 2),
                9,
                22
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `minimum cost to cut a stick test`(cuts: IntArray, n: Int, expected: Int) {
        val actual = MinimumCostToCutStick().perform(n, cuts)
        assertEquals(expected, actual)
    }
}
