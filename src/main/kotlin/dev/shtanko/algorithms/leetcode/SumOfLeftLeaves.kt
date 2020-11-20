package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

internal interface SumOfLeftLeavesStrategy {
    fun perform(root: TreeNode?): Int
}

internal class SumOfLeftLeavesIterative : SumOfLeftLeavesStrategy {
    override fun perform(root: TreeNode?): Int {
        if (root == null) return 0
        var ans = 0
        val stack: Stack<TreeNode> = Stack<TreeNode>()
        stack.push(root)

        while (!stack.empty()) {
            val node: TreeNode = stack.pop()
            if (node.left != null) {
                if (node.left!!.left == null && node.left!!.right == null) ans += node.left?.value ?: 0 else stack.push(
                    node.left
                )
            }
            if (node.right != null) {
                if (node.right!!.left != null || node.right!!.right != null) stack.push(node.right)
            }
        }
        return ans
    }
}

internal class SumOfLeftLeavesRecursive : SumOfLeftLeavesStrategy {
    override fun perform(root: TreeNode?): Int {
        if (root == null) return 0
        var ans = 0
        if (root.left != null) {
            ans += if (root.left?.left == null && root.left?.right == null) {
                root.left?.value ?: 0
            } else {
                perform(root.left)
            }
        }
        ans += perform(root.right)
        return ans
    }
}

internal class SumOfLeftLeavesBSF : SumOfLeftLeavesStrategy {
    override fun perform(root: TreeNode?): Int {
        if (root == null) return 0

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        var sum = 0
        while (!queue.isEmpty()) {
            val presentNode: TreeNode = queue.poll()
            if (presentNode.left != null) {
                queue.add(presentNode.left)
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right)
            }
            if (presentNode.left != null && presentNode.left!!.left == null && presentNode.left!!.right == null) {
                sum += presentNode.left?.value ?: 0
            }
        }
        return sum
    }
}
