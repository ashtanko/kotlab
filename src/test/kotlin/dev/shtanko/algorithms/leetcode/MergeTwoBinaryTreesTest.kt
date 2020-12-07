package dev.shtanko.algorithms.leetcode

import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MergeTwoBinaryTreesTest {

    private lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender(BinaryTree::class.java)
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
    }

    @Test
    internal fun `print level order in root is null test`() {
        val tree = BinaryTree()
        tree.printLevelOrder()
    }

    @Test
    internal fun `print level order in root tree test`() {
        val tree = BinaryTree().apply {
            root = TreeNode(1)
        }
        tree.printLevelOrder()
    }

    @Test
    internal fun `merge two binary trees test`() {
        val tree1 = BinaryTree().apply {
            root = TreeNode(1).apply {
                left = TreeNode(3).apply {
                    left = TreeNode(5)
                }
                right = TreeNode(2)
            }
        }
        tree1.printLevelOrder()

        val tree2 = BinaryTree().apply {
            root = TreeNode(2).apply {
                left = TreeNode(1).apply {
                    right = TreeNode(4)
                }
                right = TreeNode(3).apply {
                    right = TreeNode(7)
                }
            }
        }

        val t1 = tree1.root
        val t2 = tree2.root
        val result = (t1 to t2).mergeTrees()

        val tree3 = BinaryTree()
        tree3.root = result
    }
}
