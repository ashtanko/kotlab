package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class VerifyPreorderInBinarySearchTreeTest<out T : VerifyPreorderInBinarySearchTreeStrategy>(
    private val strategy: T
) {

    //      5
    //     / \
    //    2   6
    //   / \
    //  1   3
    // Preorder (Root, Left, Right)
    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(intArrayOf(5, 2, 6, 1, 3), false),
            Arguments.of(intArrayOf(5, 2, 1, 3, 6), true)
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `verify test`(preorder: IntArray, expected: Boolean) {
        val actual = strategy.perform(preorder)
        assertEquals(expected, actual)
    }
}

class VerifyPreorderInBinarySearchTreeBFTest :
    VerifyPreorderInBinarySearchTreeTest<VerifyPreorderInBinarySearchTreeBF>(VerifyPreorderInBinarySearchTreeBF())

class VerifyPreorderInBinarySearchTreeStackTest :
    VerifyPreorderInBinarySearchTreeTest<VerifyPreorderInBinarySearchTreeStack>(VerifyPreorderInBinarySearchTreeStack())

class VerifyPreorderInBinarySearchTreeRecursionTest :
    VerifyPreorderInBinarySearchTreeTest<VerifyPreorderInBinarySearchTreeRecursion>(
        VerifyPreorderInBinarySearchTreeRecursion()
    )
