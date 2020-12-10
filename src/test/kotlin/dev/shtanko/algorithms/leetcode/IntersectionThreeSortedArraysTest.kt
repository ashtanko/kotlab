package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class IntersectionThreeSortedArraysTest<out T : IntersectionThreeSortedArrays>(private val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(1, 2, 5, 7, 9),
                intArrayOf(1, 3, 4, 5, 8),
                listOf(1, 5),
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `intersection of three sorted arrays test`(
        arr1: IntArray,
        arr2: IntArray,
        arr3: IntArray,
        expected: List<Int>
    ) {
        val actual = strategy.perform(arr1, arr2, arr3)
        assertEquals(expected, actual)
    }
}

internal class IntersectionThreeSortedBruteForceTest :
    IntersectionThreeSortedArraysTest<IntersectionThreeSortedBruteForce>(IntersectionThreeSortedBruteForce())

internal class IntersectionThreeSortedThreePointersTest :
    IntersectionThreeSortedArraysTest<IntersectionThreeSortedThreePointers>(IntersectionThreeSortedThreePointers())
