package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.EliminateMaximumStrategy.Heap
import dev.shtanko.algorithms.leetcode.EliminateMaximumStrategy.Sort
import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class EliminateMaxNumOfMonstersTest<out T : EliminateMaxNumOfMonsters>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 3, 4),
                intArrayOf(1, 1, 1),
                3,
            ),
            Arguments.of(
                intArrayOf(1, 1, 2, 3),
                intArrayOf(1, 1, 1, 1),
                1,
            ),
            Arguments.of(
                intArrayOf(3, 2, 4),
                intArrayOf(5, 3, 2),
                1,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `eliminate maximum test`(dist: IntArray, speed: IntArray, expected: Int) {
        val actual = strategy(dist, speed)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class EliminateMaxSortTest : EliminateMaxNumOfMonstersTest<EliminateMaxNumOfMonsters>(Sort)
class EliminateMaxHeapTest : EliminateMaxNumOfMonstersTest<EliminateMaxNumOfMonsters>(Heap)
