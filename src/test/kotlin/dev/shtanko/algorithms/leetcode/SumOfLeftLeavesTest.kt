package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class SumOfLeftLeavesTest<out T : SumOfLeftLeavesStrategy>(val strategy: T) {

    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(3).apply {
                    left = TreeNode(9)
                    right = TreeNode(20).apply {
                        left = TreeNode(15)
                        right = TreeNode(7)
                    }
                },
                24
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `sum of left leaves test`(tree: TreeNode, expected: Int) {
        val actual = strategy.perform(tree)
        assertEquals(expected, actual)
    }
}

internal class SumOfLeftLeavesIterativeTest : SumOfLeftLeavesTest<SumOfLeftLeavesIterative>(SumOfLeftLeavesIterative())

internal class SumOfLeftLeavesRecursiveTest : SumOfLeftLeavesTest<SumOfLeftLeavesRecursive>(SumOfLeftLeavesRecursive())

internal class SumOfLeftLeavesBSFTest : SumOfLeftLeavesTest<SumOfLeftLeavesBSF>(SumOfLeftLeavesBSF())
