package dev.shtanko.algorithms.leetcode

internal class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

internal fun TreeNode?.clone(): TreeNode? {
    if (this == null) return null
    val node = TreeNode(value)
    node.left = left.clone()
    node.right = right.clone()
    return node
}
