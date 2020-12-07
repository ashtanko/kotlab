package dev.shtanko.algorithms.leetcode

import org.slf4j.LoggerFactory

internal class BinaryTree {
    var root: TreeNode? = null

    companion object {
        private val LOGGER = LoggerFactory.getLogger(BinaryTree::class.java)
    }

    fun printLevelOrder() {
        val h = height(root)
        for (i in 1 until h) {
            printGivenLevel(root, i)
        }
    }

    private fun printGivenLevel(root: TreeNode?, level: Int) {
        if (root == null) {
            return
        }
        if (level == 1) {
            LOGGER.info("${root.value}")
        } else if (level > 1) {
            printGivenLevel(root.left, level - 1)
            printGivenLevel(root.right, level - 1)
        }
    }

    private fun height(root: TreeNode?): Int {
        return if (root == null) {
            0
        } else {
            val lHeight = height(root.left)
            val rHeight = height(root.right)

            if (lHeight > rHeight) {
                lHeight + 1
            } else {
                rHeight + 1
            }
        }
    }
}
