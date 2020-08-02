package dev.shtanko.algorithms.leetcode

object BinaryTreeMaximumPathSum {

    private var maxValue = Int.MIN_VALUE

    internal fun TreeNode?.maxPathSum(): Int {
        maxValue = Int.MIN_VALUE
        this.maxPathDown()
        return maxValue
    }

    private fun TreeNode?.maxPathDown(): Int {
        if (this == null) return 0
        val left = 0.coerceAtLeast(this.left.maxPathDown())
        val right = 0.coerceAtLeast(this.right.maxPathDown())
        maxValue = maxValue.coerceAtLeast(left + right + this.value)
        return left.coerceAtLeast(right) + this.value
    }
}
