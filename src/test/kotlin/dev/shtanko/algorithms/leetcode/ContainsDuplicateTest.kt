package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class ContainsDuplicateTest<out T : ContainsDuplicateStrategy>(private val strategy: T) {

    companion object {

        private val duplicateShortArray = intArrayOf(1, 2, 3, 1)
        private val duplicateArray = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        private val uniqueArray = intArrayOf(1, 2, 3, 4)

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(duplicateShortArray to true, duplicateArray to true, uniqueArray to false),
                Arguments.of(duplicateArray to true, uniqueArray to false),
                Arguments.of(uniqueArray to false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `duplicate items test`(testCase: Pair<IntArray, Boolean>) {
        val (arr, expected) = testCase
        val actual = strategy.perform(arr)
        assertEquals(expected, actual)
    }
}

internal class IsContainsDuplicateBrutForceTest :
    ContainsDuplicateTest<IsContainsDuplicateBrutForce>(IsContainsDuplicateBrutForce())

internal class IsContainsDuplicateSortTest :
    ContainsDuplicateTest<IsContainsDuplicateSort>(IsContainsDuplicateSort())

internal class IsContainsDuplicateSortSetTest :
    ContainsDuplicateTest<IsContainsDuplicateSortSet>(IsContainsDuplicateSortSet())

internal class IsContainsDuplicateSortSetOptimizedTest :
    ContainsDuplicateTest<IsContainsDuplicateSortSetOptimized>(IsContainsDuplicateSortSetOptimized())

internal class IsContainsDuplicateBitManipulationTest :
    ContainsDuplicateTest<IsContainsDuplicateBitManipulation>(IsContainsDuplicateBitManipulation())
