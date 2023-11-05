package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.GetWinnerStrategy.NoQueueSolution
import dev.shtanko.algorithms.leetcode.GetWinnerStrategy.QueueSolution
import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class GetWinnerTest<out T : GetWinner>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(2, 1, 3, 5, 4, 6, 7),
                2,
                5,
            ),
            Arguments.of(
                intArrayOf(3, 2, 1),
                10,
                3,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `get winner test`(arr: IntArray, k: Int, expected: Int) {
        val actual = strategy(arr, k)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class GetWinnerQueueTest : GetWinnerTest<GetWinner>(QueueSolution)
class GetWinnerNoQueueTest : GetWinnerTest<GetWinner>(NoQueueSolution)
