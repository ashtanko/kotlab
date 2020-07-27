package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreePreorderTraversalTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right?.left = TreeNode(3)
        val actual = root.preorderTraversal()
        val expected = listOf(1, 2, 3)
        assertEquals(expected, actual)
    }
}
