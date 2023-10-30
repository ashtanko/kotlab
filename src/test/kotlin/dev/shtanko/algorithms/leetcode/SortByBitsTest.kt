package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class SortByBitsTest<out T : SortByBits>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
                intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7),
            ),
            Arguments.of(
                intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1),
                intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024),
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `sort by bits test`(arr: IntArray, expected: IntArray) {
        val actual = strategy(arr)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class SortByBitsComparatorSolutionTest : SortByBitsTest<SortByBits>(SortByBitsStrategy.ComparatorSolution)
class SortByBitsBitManipulationTest : SortByBitsTest<SortByBits>(SortByBitsStrategy.BitManipulation)
class SortByBitsBrianKerninghansAlgorithmTest : SortByBitsTest<SortByBits>(SortByBitsStrategy.BrianKerninghansAlgorithm)
