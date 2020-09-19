package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal abstract class UnivaluedBinaryTreeStrategyTest<out T : UnivaluedBinaryTreeStrategy>(private val strategy: T) {

    @Test
    fun `simple test`() {
        val tree = TreeNode(1)
        tree.left = TreeNode(1)
        tree.left?.left = TreeNode(1)
        tree.left?.right = TreeNode(1)
        tree.right = TreeNode(1)
        tree.right?.right = TreeNode(1)
        assertTrue(strategy.perform(tree))
    }

    @Test
    fun `simple test 2`() {
        val tree = TreeNode(2)
        tree.left = TreeNode(2)
        tree.right = TreeNode(2)
        tree.left?.left = TreeNode(5)
        tree.left?.right = TreeNode(2)
        assertFalse(strategy.perform(tree))
    }
}

internal class UnivaluedBinaryTreeDFSTest :
    UnivaluedBinaryTreeStrategyTest<UnivaluedBinaryTreeDFS>(UnivaluedBinaryTreeDFS())

internal class UnivaluedBinaryTreeRecursiveTest :
    UnivaluedBinaryTreeStrategyTest<UnivaluedBinaryTreeRecursive>(UnivaluedBinaryTreeRecursive())
