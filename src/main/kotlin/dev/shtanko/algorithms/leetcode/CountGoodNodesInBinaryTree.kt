package dev.shtanko.algorithms.leetcode

import kotlin.math.max

class CountGoodNodesInBinaryTree {

    companion object {
        private const val MIN_VALUE = -10000
    }

    fun goodNodes(root: TreeNode?): Int {
        return goodNodes(root, MIN_VALUE)
    }

    private fun goodNodes(root: TreeNode?, ma: Int): Int {
        if (root == null) return 0
        var res = if (root.value >= ma) 1 else 0
        res += goodNodes(root.left, max(ma, root.value))
        res += goodNodes(root.right, max(ma, root.value))
        return res
    }
}
