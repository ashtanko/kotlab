package dev.shtanko.algorithms.leetcode

import java.util.Stack

internal fun rangeSumBST(root: TreeNode?, left: Int, right: Int): Int {
    var ans = 0
    val stack: Stack<TreeNode> = Stack()
    stack.push(root)
    while (!stack.isEmpty()) {
        val node: TreeNode? = stack.pop()
        if (node != null) {
            if (node.value in left..right) ans += node.value
            if (left < node.value) stack.push(node.left)
            if (node.value < right) stack.push(node.right)
        }
    }
    return ans
}

internal fun rangeSumBSTRecursive(root: TreeNode?, left: Int, right: Int): Int {
    return dfs(root, left, right, 0)
}

private fun dfs(node: TreeNode?, left: Int, right: Int, a: Int): Int {
    var ans = a
    if (node != null) {
        if (node.value in left..right) ans += node.value
        if (left < node.value) ans = dfs(node.left, left, right, ans)
        if (node.value < right) ans = dfs(node.right, left, right, ans)
    }
    return ans
}
