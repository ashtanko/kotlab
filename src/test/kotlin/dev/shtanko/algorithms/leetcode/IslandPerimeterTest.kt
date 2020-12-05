package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class IslandPerimeterTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf<IntArray>(),
                0
            ),
            Arguments.of(
                arrayOf(intArrayOf()),
                0
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(1, 1, 1, 0),
                    intArrayOf(0, 1, 0, 0),
                    intArrayOf(1, 1, 0, 0)
                ),
                16
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `island perimeter test`(arr: Array<IntArray>, expected: Int) {
        val actual = arr.islandPerimeter()
        assertEquals(expected, actual)
    }
}
