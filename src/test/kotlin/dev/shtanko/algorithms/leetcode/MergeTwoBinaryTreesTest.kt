package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Test

internal class MergeTwoBinaryTreesTest {

    @Test
    internal fun `merge two binary trees test`() {
        val tree1 = BinaryTree()
        tree1.root = TreeNode(1)
        tree1.root?.left = TreeNode(3)
        tree1.root?.left?.left = TreeNode(5)
        tree1.root?.right = TreeNode(2)

        tree1.printLevelOrder()

        val tree2 = BinaryTree()
        tree2.root = TreeNode(2)
        tree2.root?.left = TreeNode(1)
        tree2.root?.left?.right = TreeNode(4)
        tree2.root?.right = TreeNode(3)
        tree2.root?.right?.right = TreeNode(7)

        val t1 = tree1.root
        val t2 = tree1.root
        val result = (t1 to t2).mergeTrees()

        val tree3 = BinaryTree()
        tree3.root = result
    }
}
