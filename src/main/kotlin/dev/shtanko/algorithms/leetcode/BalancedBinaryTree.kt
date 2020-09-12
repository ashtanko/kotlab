package dev.shtanko.algorithms.leetcode

import kotlin.math.abs

internal fun isBalanced(root: TreeNode?): Boolean {
    return balancedHelper(root) >= 0
}

internal fun balancedHelper(root: TreeNode?, height: Int = 0): Int {
    if (root == null) {
        return height
    }
    val leftTree = balancedHelper(root.left, height + 1)
    val rightTree = balancedHelper(root.right, height + 1)
    if (leftTree < 0 || rightTree < 0 || abs(leftTree - rightTree) > 1) {
        return -1
    }
    return leftTree.coerceAtLeast(rightTree)
}
