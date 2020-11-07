package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

abstract class ContainsDuplicateTest<out T : ContainsDuplicateStrategy>(private val strategy: T) {

    companion object {

        private val duplicateShortArray = intArrayOf(1, 2, 3, 1)
        private val duplicateArray = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)
        private val uniqueArray = intArrayOf(1, 2, 3, 4)

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(duplicateShortArray to true, duplicateArray to true, uniqueArray to false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun `duplicate items test`(
        duplicateShort: Pair<IntArray, Boolean>,
        duplicate: Pair<IntArray, Boolean>,
        unique: Pair<IntArray, Boolean>
    ) {
        assertEquals(strategy.perform(duplicateShort.first), duplicateShort.second)
        assertEquals(strategy.perform(duplicate.first), duplicate.second)
        assertEquals(strategy.perform(unique.first), unique.second)
    }
}

class IsContainsDuplicateBrutForceTest :
    ContainsDuplicateTest<IsContainsDuplicateBrutForce>(IsContainsDuplicateBrutForce())

class IsContainsDuplicateSortTest :
    ContainsDuplicateTest<IsContainsDuplicateSort>(IsContainsDuplicateSort())

class IsContainsDuplicateSortSetTest :
    ContainsDuplicateTest<IsContainsDuplicateSortSet>(IsContainsDuplicateSortSet())

class IsContainsDuplicateSortSetOptimizedTest :
    ContainsDuplicateTest<IsContainsDuplicateSortSetOptimized>(IsContainsDuplicateSortSetOptimized())

class IsContainsDuplicateBitManipulationTest :
    ContainsDuplicateTest<IsContainsDuplicateBitManipulation>(IsContainsDuplicateBitManipulation())
