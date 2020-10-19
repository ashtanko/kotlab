package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RecoverBinarySearchTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(1).apply {
            left = TreeNode(3)
            left?.right = TreeNode(2)
        }
        recoverTree(root)
        val list = listOf(
            root.value,
            root.left?.value,
            root.left?.right?.value
        )
        assertEquals(listOf(3, 1, 2), list)
    }

    @Test
    fun `simple test 2`() {
        val root = TreeNode(3).apply {
            left = TreeNode(1)
            right = TreeNode(4).apply {
                left = TreeNode(2)
            }
        }
        recoverTree(root)
        val list = listOf(
            root.value,
            root.left?.value,
            root.right?.value,
            root.right?.left?.value
        )
        assertEquals(listOf(2, 1, 4, 3), list)
    }
}
