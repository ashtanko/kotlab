package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class SmallestDivisorStrategyTest<out T : SmallestDivisorStrategy>(private val strategy: T) {
    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(1, 2, 5, 9),
                6,
                5
            ),
            Arguments.of(
                intArrayOf(2, 3, 5, 7, 11),
                11,
                3
            ),
            Arguments.of(
                intArrayOf(19),
                5,
                4
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `find the smallest divisor given a threshold test`(nums: IntArray, threshold: Int, expected: Int) {
        val actual = strategy.perform(nums, threshold)
        assertEquals(expected, actual)
    }
}

class SmallestDivisorBinarySearchTest :
    SmallestDivisorStrategyTest<SmallestDivisorBinarySearch>(SmallestDivisorBinarySearch())

class SmallestDivisorMathTest : SmallestDivisorStrategyTest<SmallestDivisorMath>(SmallestDivisorMath())
