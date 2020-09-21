package dev.shtanko.algorithms.leetcode

import java.util.Stack

internal fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return 1 + maxDepth(root.left).coerceAtLeast(maxDepth(root.right))
}

internal fun maxDepthIterative(root: TreeNode?): Int {
    if (root == null) return 0
    val nodeStack = Stack<TreeNode>()
    val depthStack = Stack<Int>()
    nodeStack.push(root)
    depthStack.push(1)
    var max = 1

    while (nodeStack.isNotEmpty()) {
        val curr = nodeStack.pop()
        val depth = depthStack.pop()

        if (curr.left == null && curr.right == null) {
            max = max.coerceAtLeast(depth)
        }

        if (curr.right != null) {
            nodeStack.push(curr.right)
            depthStack.push(depth + 1)
        }
        if (curr.left != null) {
            nodeStack.push(curr.left)
            depthStack.push(depth + 1)
        }
    }
    return max
}