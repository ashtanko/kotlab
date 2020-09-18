package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Queue

internal interface InvertTreeStrategy {
    fun perform(root: TreeNode?): TreeNode?
}

internal class InvertTree : InvertTreeStrategy {
    override fun perform(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val current: TreeNode = queue.poll()
            val temp = current.left
            current.left = current.right
            current.right = temp
            if (current.left != null) queue.add(current.left)
            if (current.right != null) queue.add(current.right)
        }
        return root
    }
}

internal class InvertTreeRecursive : InvertTreeStrategy {
    override fun perform(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val right: TreeNode? = perform(root.right)
        val left: TreeNode? = perform(root.left)
        root.left = right
        root.right = left
        return root
    }
}
