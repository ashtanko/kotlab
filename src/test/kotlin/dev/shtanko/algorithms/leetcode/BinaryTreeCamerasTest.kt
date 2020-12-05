package dev.shtanko.algorithms.leetcode

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

internal abstract class BinaryTreeCamerasTest<out T : BinaryTreeCamerasStrategy>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0)
                        right = TreeNode(0)
                    }
                },
                1
            ),
            Arguments.of(
                TreeNode(0).apply {
                    left = TreeNode(0).apply {
                        left = TreeNode(0).apply {
                            left = TreeNode(0).apply {
                                right = TreeNode(0)
                            }
                        }
                    }
                },
                2
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `simple test`(root: TreeNode, expected: Int) {
        val actual = strategy.perform(root)
        assertEquals(expected, actual)
    }
}

internal class BinaryTreeCamerasDFSTest : BinaryTreeCamerasTest<BinaryTreeCamerasDFS>(BinaryTreeCamerasDFS())
internal class BinaryTreeCamerasDPTest : BinaryTreeCamerasTest<BinaryTreeCamerasDP>(BinaryTreeCamerasDP())
internal class BinaryTreeCamerasGreedyTest : BinaryTreeCamerasTest<BinaryTreeCamerasGreedy>(BinaryTreeCamerasGreedy())
