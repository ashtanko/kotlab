package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LeafSimilarTreesTest {

    @Test
    fun `simple test`() {
        val root1 = TreeNode(3)
        root1.left = TreeNode(5)
        root1.left?.left = TreeNode(6)
        root1.left?.right = TreeNode(2)
        root1.left?.right?.left = TreeNode(7)
        root1.left?.right?.right = TreeNode(4)
        root1.right = TreeNode(1)
        root1.right?.left = TreeNode(9)
        root1.right?.right = TreeNode(8)

        val root2 = TreeNode(3)
        root2.left = TreeNode(5)
        root2.left?.left = TreeNode(6)
        root2.left?.right = TreeNode(7)

        root2.right = TreeNode(1)
        root2.right?.left = TreeNode(4)
        root2.right?.right = TreeNode(2)
        root2.right?.right?.right = TreeNode(8)
        root2.right?.right?.left = TreeNode(9)

        assertTrue(leafSimilar(root1, root2))
    }

    @Test
    fun `simple test 2`() {
        val root1 = TreeNode(1)
        val root2 = TreeNode(1)

        assertTrue(leafSimilar(root1, root2))
    }

    @Test
    fun `simple test 3`() {
        val root1 = TreeNode(1)
        val root2 = TreeNode(2)

        assertFalse(leafSimilar(root1, root2))
    }

    @Test
    fun `simple test 4`() {
        val root1 = TreeNode(1)
        root1.left = TreeNode(2)
        val root2 = TreeNode(2)
        root2.left = TreeNode(2)
        assertTrue(leafSimilar(root1, root2))
    }

    @Test
    fun `simple test 5`() {
        val root1 = TreeNode(1)
        root1.left = TreeNode(2)
        root1.right = TreeNode(3)

        val root2 = TreeNode(1)
        root2.left = TreeNode(3)
        root2.right = TreeNode(2)
        assertFalse(leafSimilar(root1, root2))
    }
}
