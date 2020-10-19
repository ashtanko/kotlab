package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrimBinarySearchTreeTest {

    @Test
    fun `simple test`() {
        val root = TreeNode(1).apply {
            left = TreeNode(0)
            right = TreeNode(2)
        }
        val low = 1
        val high = 2
        val actual = trimBST(root, low, high).levelOrder()
        val expected = listOf(
            listOf(1),
            listOf(2)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val root = TreeNode(3).apply {
            left = TreeNode(0).apply {
                right = TreeNode(2).apply {
                    left = TreeNode(1)
                }
            }
            right = TreeNode(4)
        }
        val low = 1
        val high = 3
        val actual = trimBST(root, low, high).levelOrder()
        val expected = listOf(
            listOf(3),
            listOf(2),
            listOf(1)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val root = TreeNode(1)
        val low = 1
        val high = 2
        val actual = trimBST(root, low, high).levelOrder()
        val expected = listOf(
            listOf(1)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 4`() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        val low = 1
        val high = 3
        val actual = trimBST(root, low, high).levelOrder()
        val expected = listOf(
            listOf(1),
            listOf(2)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 5`() {
        val root = TreeNode(1)
        root.right = TreeNode(2)
        val low = 2
        val high = 4
        val actual = trimBST(root, low, high).levelOrder()
        val expected = listOf(
            listOf(2)
        )
        assertEquals(expected, actual)
    }
}
