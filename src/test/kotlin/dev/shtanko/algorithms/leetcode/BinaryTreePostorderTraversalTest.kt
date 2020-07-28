package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BinaryTreePostorderTraversalTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        root.right?.left = TreeNode(3)
        val actual = root.postOrderTraversal()
        val expected = listOf(3, 2, 1)
        Assertions.assertEquals(expected, actual)
    }
}
