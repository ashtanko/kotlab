package dev.shtanko.algorithms.leetcode

internal fun TreeNode?.isSymmetric(): Boolean {
    return this == null || (left to right).isSymmetric()
}

internal fun Pair<TreeNode?, TreeNode?>.isSymmetric(): Boolean {
    if (first == null || second == null) {
        return first == second
    }
    if (first?.value != second?.value) {
        return false
    }
    return (first?.left to second?.right).isSymmetric() && (first?.right to second?.left).isSymmetric()
}
