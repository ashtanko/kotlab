package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class BuildArrayWithStackOperationsTest {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(1, 3), 3, listOf("Push", "Push", "Pop", "Push")),
            Arguments.of(intArrayOf(1, 2, 3), 3, listOf("Push", "Push", "Push")),
            Arguments.of(intArrayOf(1, 2), 4, listOf("Push", "Push")),
            Arguments.of(intArrayOf(2, 3, 4), 4, listOf("Push", "Pop", "Push", "Push", "Push")),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `build an array with stack operations test`(target: IntArray, n: Int, expected: List<String>) {
        val actual = BuildArrayWithStackOperations().perform(target, n)
        assertEquals(expected, actual)
    }
}
