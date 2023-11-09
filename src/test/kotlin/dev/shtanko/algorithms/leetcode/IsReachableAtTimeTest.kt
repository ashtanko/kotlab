package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class IsReachableAtTimeTest<out T : IsReachableAtTime>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(2, 4, 7, 7, 6, true),
            Arguments.of(3, 1, 7, 3, 3, false),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `is reachable at time test`(sx: Int, sy: Int, fx: Int, fy: Int, t: Int, expected: Boolean) {
        val actual = strategy(sx, sy, fx, fy, t)
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

class IsReachableAtTimeMathTest : IsReachableAtTimeTest<IsReachableAtTime>(IsReachableAtTimeMath())
