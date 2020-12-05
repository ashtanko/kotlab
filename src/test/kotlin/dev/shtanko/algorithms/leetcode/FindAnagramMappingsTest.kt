package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class FindAnagramMappingsTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(12, 28, 46, 32, 50),
                intArrayOf(50, 12, 32, 46, 28),
                intArrayOf(1, 4, 3, 2, 0)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `internal test`(a: IntArray, b: IntArray, expected: IntArray) {
        val actual = FindAnagramMappings.perform(a, b)
        assertArrayEquals(expected, actual)
    }
}
