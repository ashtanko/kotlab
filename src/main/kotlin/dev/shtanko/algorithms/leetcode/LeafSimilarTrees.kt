package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

internal fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val leaves1: MutableList<Int?> = ArrayList()
    val leaves2: MutableList<Int?> = ArrayList()
    dfs(root1, leaves1)
    dfs(root2, leaves2)
    return leaves1 == leaves2
}

internal fun dfs(node: TreeNode?, leafValues: MutableList<Int?>) {
    if (node != null) {
        if (node.left == null && node.right == null) leafValues.add(node.value)
        dfs(node.left, leafValues)
        dfs(node.right, leafValues)
    }
}
