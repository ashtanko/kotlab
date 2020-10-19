package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LeafSimilarTreesTest {

    @Test
    fun `simple test`() {
        val root1 = TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(6)
                right = TreeNode(2)
                right?.left = TreeNode(7)
                right?.right = TreeNode(4)
            }
            right = TreeNode(1).apply {
                left = TreeNode(9)
                right = TreeNode(8)
            }
        }

        val root2 = TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(6)
                right = TreeNode(7)
            }
            right = TreeNode(1).apply {
                left = TreeNode(4)
                right = TreeNode(2).apply {
                    right = TreeNode(8)
                    left = TreeNode(9)
                }
            }
        }
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
        val root1 = TreeNode(1).apply {
            left = TreeNode(2)
        }
        val root2 = TreeNode(2).apply {
            left = TreeNode(2)
        }
        assertTrue(leafSimilar(root1, root2))
    }

    @Test
    fun `simple test 5`() {
        val root1 = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }

        val root2 = TreeNode(1).apply {
            left = TreeNode(3)
            right = TreeNode(2)
        }
        assertFalse(leafSimilar(root1, root2))
    }
}
