package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

internal fun delNodes(root: TreeNode?, toDelete: IntArray): List<TreeNode?> {
    val set: MutableSet<Int> = HashSet()
    for (i in toDelete) set.add(i)
    val res: MutableList<TreeNode?> = ArrayList()
    if (!set.contains(root?.value)) res.add(root)
    dfs(root, set, res)
    return res
}

private fun dfs(node: TreeNode?, set: Set<Int>, res: MutableList<TreeNode?>): TreeNode? {
    if (node == null) {
        return null
    }
    node.left = dfs(node.left, set, res)
    node.right = dfs(node.right, set, res)
    if (set.contains(node.value)) {
        if (node.left != null) res.add(node.left)
        if (node.right != null) res.add(node.right)
        return null
    }
    return node
}
