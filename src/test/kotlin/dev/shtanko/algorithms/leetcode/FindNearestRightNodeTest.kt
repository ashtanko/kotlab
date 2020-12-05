package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class FindNearestRightNodeTest<out T : FindNearestRightNodeStrategy>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        right = TreeNode(4)
                    }
                    right = TreeNode(3).apply {
                        left = TreeNode(5)
                        right = TreeNode(6)
                    }
                },
                TreeNode(4),
                TreeNode(5)
            ),
            Arguments.of(
                TreeNode(3).apply {
                    right = TreeNode(4).apply {
                        left = TreeNode(2)
                    }
                },
                TreeNode(2),
                null
            ),
            Arguments.of(
                TreeNode(1),
                TreeNode(1),
                null
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `find nearest right node in binary tree test`(root: TreeNode, u: TreeNode, expected: TreeNode?) {
        val actual = strategy.perform(root, u).levelOrder().flatten()
        assertEquals(expected.levelOrder().flatten(), actual)
    }
}

internal class FindNearestRightNodeTwoQueuesTest :
    FindNearestRightNodeTest<FindNearestRightNodeTwoQueues>(FindNearestRightNodeTwoQueues())

internal class FindNearestRightNodeSentinelTest :
    FindNearestRightNodeTest<FindNearestRightNodeSentinel>(FindNearestRightNodeSentinel())

internal class FindNearestRightNodeSizeMeasurementsTest :
    FindNearestRightNodeTest<FindNearestRightNodeSizeMeasurements>(FindNearestRightNodeSizeMeasurements())

internal class FindNearestRightNodeSizePreorderTraversalTest :
    FindNearestRightNodeTest<FindNearestRightNodeSizePreorderTraversal>(FindNearestRightNodeSizePreorderTraversal())
