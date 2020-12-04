package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class TwoSumLessThanKTest<out T : TwoSumLessThanKStrategy>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                intArrayOf(34, 23, 1, 24, 75, 33, 54, 8),
                60,
                58
            ),
            Arguments.of(
                intArrayOf(10, 20, 30),
                15,
                -1
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `two sum less than K test`(nums: IntArray, k: Int, expected: Int) {
        val actual = strategy.perform(nums, k)
        assertEquals(expected, actual)
    }
}

class TwoSumLessThanKBruteForceTest : TwoSumLessThanKTest<TwoSumLessThanKBruteForce>(TwoSumLessThanKBruteForce())
class TwoSumLessThanKTwoPointersTest : TwoSumLessThanKTest<TwoSumLessThanKTwoPointers>(TwoSumLessThanKTwoPointers())
class TwoSumLessThanKBinarySearchTest : TwoSumLessThanKTest<TwoSumLessThanKBinarySearch>(TwoSumLessThanKBinarySearch())
class TwoSumLessThanKCountingSortTest : TwoSumLessThanKTest<TwoSumLessThanKCountingSort>(TwoSumLessThanKCountingSort())