package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class PascalsTriangleTest {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                0,
                listOf<List<Int>>()
            ),
            Arguments.of(
                5,
                listOf(
                    listOf(1),
                    listOf(1, 1),
                    listOf(1, 2, 1),
                    listOf(1, 3, 3, 1),
                    listOf(1, 4, 6, 4, 1)
                )
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `pascals triangle test`(n: Int, expected: List<List<Int>>) {
        val actual = n.pascalsTriangle()
        assertEquals(expected, actual)
    }
}
