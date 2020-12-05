package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class SumOfRootToLeafBinaryNumbersTest<out T : SumOfRootToLeafBinaryNumbersStrategy>(
    private val strategy: T
) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                        right = TreeNode(1)
                    }
                },
                22
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `sum of root to leaf binary numbers test`(root: TreeNode, expected: Int) {
        val actual = strategy.sumRootToLeaf(root)
        assertEquals(expected, actual)
    }
}

internal class SumOfRootToLeafBinaryNumbersIPTTest :
    SumOfRootToLeafBinaryNumbersTest<SumOfRootToLeafBinaryNumbersIPT>(SumOfRootToLeafBinaryNumbersIPT())

internal class SumOfRootToLeafBinaryNumbersRPTTest :
    SumOfRootToLeafBinaryNumbersTest<SumOfRootToLeafBinaryNumbersRPT>(SumOfRootToLeafBinaryNumbersRPT())

internal class SumOfRootToLeafBinaryNumbersMPTTest :
    SumOfRootToLeafBinaryNumbersTest<SumOfRootToLeafBinaryNumbersMPT>(SumOfRootToLeafBinaryNumbersMPT())
