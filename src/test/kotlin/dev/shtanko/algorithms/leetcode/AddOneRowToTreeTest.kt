package dev.shtanko.algorithms.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class AddOneRowToTreeTest<out T : AddOneRowToTree>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                    right = TreeNode(6).apply {
                        left = TreeNode(5)
                    }
                },
                1,
                2,
                TreeNode(4).apply {
                    left = TreeNode(1).apply {
                        left = TreeNode(2).apply {
                            left = TreeNode(3)
                            right = TreeNode(1)
                        }
                    }
                    right = TreeNode(1).apply {
                        right = TreeNode(6).apply {
                            left = TreeNode(5)
                        }
                    }
                },
            ),
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3)
                        right = TreeNode(1)
                    }
                },
                1,
                3,
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1).apply {
                            left = TreeNode(3)
                        }
                        right = TreeNode(1).apply {
                            right = TreeNode(1)
                        }
                    }
                }
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `add one row test`(tree: TreeNode, value: Int, depth: Int, expected: TreeNode) {
        val actual = strategy.perform(tree, value, depth)
        assertThat(actual.postOrderTraversal()).isEqualTo(expected.postOrderTraversal())
    }
}

internal class AddOneRowToTreeRecTest : AddOneRowToTreeTest<AddOneRowToTreeRec>(AddOneRowToTreeRec())
internal class AddOneRowToTreeStackTest : AddOneRowToTreeTest<AddOneRowToTreeStack>(AddOneRowToTreeStack())
internal class AddOneRowToTreeQueueTest : AddOneRowToTreeTest<AddOneRowToTreeQueue>(AddOneRowToTreeQueue())
