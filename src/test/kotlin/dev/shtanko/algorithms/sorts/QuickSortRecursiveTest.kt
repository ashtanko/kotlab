package dev.shtanko.algorithms.sorts

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal class QuickSortRecursiveTest {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                listOf<Int>(),
                listOf<Int>()
            ),
            Arguments.of(
                listOf<Int>(1),
                listOf<Int>(1)
            ),
            Arguments.of(
                listOf<Int>(1, 2, 3),
                listOf<Int>(1, 2, 3)
            ),
            Arguments.of(
                listOf<Int>(3, 2, 1),
                listOf<Int>(1, 2, 3)
            ),
            Arguments.of(
                listOf<Int>(5, 0, 1, 5, 3, 7, 4, 2),
                listOf<Int>(0, 1, 2, 3, 4, 5, 5, 7)
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `quick sort test`(list: List<Int>, expected: List<Int>) {
        val actual = list.quickSort()
        assertEquals(expected, actual)
    }
}
