package dev.shtanko.algorithms.leetcode

import java.util.Stack

interface PathSumStrategy {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean
}

class PathSumRecursive : PathSumStrategy {
    override fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) return false
        return if (root.left == null && root.right == null && sum - root.value == 0) true else hasPathSum(
            root.left,
            sum - root.value
        ) || hasPathSum(root.right, sum - root.value)
    }
}

class PathSumStack : PathSumStrategy {
    override fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        val stack: Stack<TreeNode> = Stack()
        stack.push(root)
        while (!stack.isEmpty() && root != null) {
            val cur: TreeNode = stack.pop()
            if (cur.left == null && cur.right == null) {
                if (cur.value == sum) return true
            }
            if (cur.right != null) {
                cur.right?.value = cur.value + cur.right!!.value
                stack.push(cur.right)
            }
            if (cur.left != null) {
                cur.left?.value = cur.value + cur.left!!.value
                stack.push(cur.left)
            }
        }
        return false
    }
}
