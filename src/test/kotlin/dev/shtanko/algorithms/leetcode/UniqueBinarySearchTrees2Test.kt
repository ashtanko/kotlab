package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal class UniqueBinarySearchTrees2Test {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                3,
                listOf(
                    listOf(listOf(3), listOf(2), listOf(1)),
                    listOf(listOf(1, 3), listOf(2)),
                    listOf(listOf(2), listOf(3), listOf(1)),
                    listOf(listOf(2), listOf(1), listOf(3)),
                    listOf(listOf(1), listOf(2), listOf(3))
                )

            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `unique binary search trees 2 test`(n: Int, expected: List<List<List<Int>>>) {
        val actual = generateTrees(n)
        val ordered = actual?.map { it.levelOrderBottom() }
        assertEquals(expected, ordered)
    }
}
