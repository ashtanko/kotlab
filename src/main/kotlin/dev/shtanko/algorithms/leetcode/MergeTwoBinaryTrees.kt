package dev.shtanko.algorithms.leetcode

internal fun Pair<TreeNode?, TreeNode?>.mergeTrees(): TreeNode? {
    return if (first == null && second == null) {
        null
    } else if (second == null) {
        first
    } else if (first == null) {
        second
    } else {
        val t = second?.value?.let { it -> first?.value?.plus(it)?.let { TreeNode(it) } }
        t?.left = (first?.left to second?.left).mergeTrees()
        t?.right = (first?.right to second?.right).mergeTrees()
        t
    }
}
