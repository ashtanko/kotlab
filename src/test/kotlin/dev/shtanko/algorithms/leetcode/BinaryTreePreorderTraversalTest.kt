package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BinaryTreePreorderTraversalTest {

    companion object {

        @JvmStatic
        private fun provideData(): Stream<Arguments?>? {
            return Stream.of(
                Arguments.of(
                    TreeNode(1).apply {
                        right = TreeNode(2)
                        right?.left = TreeNode(3)
                    },
                    listOf(1, 2, 3)
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("provideData")
    fun `binary tree preorder traversal test`(root: TreeNode, expected: List<Int>) {
        val actual = root.preorderTraversal()
        assertEquals(expected, actual)
    }
}
