package dev.shtanko.algorithms.interview

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BinaryTreeNodeTest {

    @Test
    fun `binary tree node test`() {
        testRootOnly()
        test()
    }

    private fun testRootOnly() {
        val node = BinaryTreeNode(null)
        assertTrue(node == node.getRandom())
    }

    private fun test() {
        val root = BinaryTreeNode(null)

        val left = BinaryTreeNode(root)
        root.addLeftChild(left)

        val right = BinaryTreeNode(root)
        root.addRightChild(right)

        val rightRight = BinaryTreeNode(right)
        right.addRightChild(rightRight)

        assertTrue(left == root.getRandom { 0 })
        assertTrue(right == root.getRandom { 1 })

        assertTrue(root == root.getRandom { 4 })
        var switch = false
        assertTrue(
            rightRight == root.getRandom {
                if (!switch) {
                    switch = true
                    1
                } else {
                    0
                }
            }
        )
    }
}
