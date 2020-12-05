package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class ReplaceElementsTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(),
                intArrayOf()
            ),
            Arguments.of(
                intArrayOf(17, 18, 5, 4, 6, 1),
                intArrayOf(18, 6, 6, 6, 1, -1)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `replace elements test`(arr: IntArray, expected: IntArray) {
        val actual = arr.replaceElements()
        assertArrayEquals(expected, actual)
    }
}
