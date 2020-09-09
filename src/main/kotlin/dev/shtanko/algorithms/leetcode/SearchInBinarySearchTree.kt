package dev.shtanko.algorithms.leetcode

internal fun searchBST(root: TreeNode?, value: Int): TreeNode? {
    var cur = root
    while (cur != null) {
        if (cur.value == value) break
        cur = if (cur.value > value) cur.left else cur.right
    }
    return cur
}
