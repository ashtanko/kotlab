package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class InvertBinaryTreeStrategyTest<out T : InvertTreeStrategy>(val strategy: T) {

    @Test
    fun `simple test`() {
        val tree = TreeNode(4).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
            right = TreeNode(7).apply {
                left = TreeNode(6)
                right = TreeNode(9)
            }
        }
        val invertedTree = strategy.perform(tree)
        val actual = invertedTree.levelOrder()
        val expected = listOf(
            listOf(4),
            listOf(7, 2),
            listOf(9, 6, 3, 1)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 2`() {
        val tree = TreeNode(4).apply {
            left = TreeNode(2)
            right = TreeNode(7)
        }
        val invertedTree = strategy.perform(tree)
        val actual = invertedTree.levelOrder()
        val expected = listOf(
            listOf(4),
            listOf(7, 2)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun `simple test 3`() {
        val tree = TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }
        val invertedTree = strategy.perform(tree)
        val actual = invertedTree.levelOrder()
        val expected = listOf(
            listOf(1),
            listOf(3, 2)
        )
        assertEquals(expected, actual)
    }
}

internal class InvertTreeTest : InvertBinaryTreeStrategyTest<InvertTree>(InvertTree())

internal class InvertTreeRecursiveTest : InvertBinaryTreeStrategyTest<InvertTreeRecursive>(InvertTreeRecursive())
