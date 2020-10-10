package dev.shtanko.algorithms.leetcode

import java.util.Stack

interface BSTIterator {
    fun next(): Int

    fun hasNext(): Boolean
}

internal class BSTIteratorFlattening(root: TreeNode?) : BSTIterator {

    private val nodesSorted: MutableList<Int> = ArrayList()
    private var index = -1

    init {
        inorder(root)
    }

    override fun next(): Int = nodesSorted[++this.index]

    override fun hasNext(): Boolean = index + 1 < nodesSorted.size

    private fun inorder(root: TreeNode?) {
        val tree = root ?: return
        inorder(tree.left)
        nodesSorted.add(tree.value)
        inorder(tree.right)
    }
}

internal class BSTIteratorControlledRecursion(root: TreeNode?) : BSTIterator {

    private val stack = Stack<TreeNode>()

    init {
        leftMostInorder(root)
    }

    override fun next(): Int {
        val topmostNode = this.stack.pop()
        if (topmostNode.right != null) {
            leftMostInorder(topmostNode.right)
        }
        return topmostNode.value
    }

    override fun hasNext(): Boolean = this.stack.isNotEmpty()

    private fun leftMostInorder(root: TreeNode?) {
        var tree = root
        while (tree != null) {
            this.stack.push(tree)
            tree = tree.left
        }
    }
}
