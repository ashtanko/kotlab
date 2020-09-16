package dev.shtanko.algorithms.leetcode

import java.util.Stack

internal class BinaryTree {
    var root: TreeNode? = null

    fun inorder() {
        if (root == null) return
        val stack = Stack<TreeNode>()
        var curr: TreeNode? = root
        while (curr != null || stack.size > 0) {
            while (curr != null) {
                stack.push(curr)
                curr = curr.left
            }
            curr = stack.pop()
            print(curr.value)
            curr = curr.right
        }
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
            println(root.value)
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

    private fun preorder(node: TreeNode?) {
        if (root == null) return
        println(node?.value)
        preorder(node?.left)
        preorder(node?.right)
    }

    fun printPreorder() {
        preorder(root)
    }
}
