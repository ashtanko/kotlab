package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class RecoverBinarySearchTreeTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Pair<TreeNode, List<Int>>> {
            return listOf(
                TreeNode(1).apply {
                    left = TreeNode(3)
                    left?.right = TreeNode(2)
                } to listOf(3, 1, 2),
                TreeNode(3).apply {
                    left = TreeNode(1)
                    right = TreeNode(4).apply {
                        left = TreeNode(2)
                    }
                } to listOf(2, 1, 4, 3)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    internal fun `recover tree test`(testCase: Pair<TreeNode, List<Int>>) {
        val (root, expected) = testCase
        recoverTree(root)
        val actual = root.levelOrder().flatten()
        assertEquals(expected, actual)
    }
}
