package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.BinaryTreeMaximumPathSum.maxPathSum
import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class BinaryTreeMaximumPathSumTest {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    TreeNode(1).apply {
                        left = TreeNode(2)
                        right = TreeNode(3)
                    },
                    6
                ),
                Arguments.of(
                    TreeNode(-10).apply {
                        left = TreeNode(9)
                        right = TreeNode(20)
                        right?.apply {
                            right = TreeNode(7)
                            left = TreeNode(15)
                        }
                    },
                    42
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    internal fun `binary tree maximum path test`(tree: TreeNode, expected: Int) {
        val actual = tree.maxPathSum()
        assertEquals(expected, actual)
    }
}
