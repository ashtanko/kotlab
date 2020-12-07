package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal abstract class ContainsDuplicate2Test<out T : ContainsDuplicate2>(private val strategy: T) {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(intArrayOf(), 0, false),
                Arguments.of(intArrayOf(1, 2, 3, 1), 3, true),
                Arguments.of(intArrayOf(1, 0, 1, 1), 1, true),
                Arguments.of(intArrayOf(1, 2, 3, 1, 2, 3), 2, false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `is contains duplicate test`(arr: IntArray, k: Int, expected: Boolean) {
        val actual = strategy.perform(arr, k)
        assertEquals(expected, actual)
    }
}

internal class ContainsDuplicateLinearTest : ContainsDuplicate2Test<ContainsDuplicateLinear>(ContainsDuplicateLinear())
internal class ContainsDuplicateBinarySearchTreeTest :
    ContainsDuplicate2Test<ContainsDuplicateBinarySearchTree>(ContainsDuplicateBinarySearchTree())

internal class ContainsDuplicateHashTest : ContainsDuplicate2Test<ContainsDuplicateHash>(ContainsDuplicateHash())
