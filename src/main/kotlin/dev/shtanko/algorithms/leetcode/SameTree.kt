package dev.shtanko.algorithms.leetcode

internal fun Pair<TreeNode?, TreeNode?>.isSame(): Boolean {
    if (first == null && second == null) return true
    if (first == null || second == null) return false
    if (first?.value == second?.value) {
        return (first?.left to second?.left).isSame() && (first?.right to second?.right).isSame()
    }

    return false
}
