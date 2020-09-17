package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

internal fun increasingBST(root: TreeNode?): TreeNode? {
    val vals: MutableList<Int?> = ArrayList()
    inorder(root, vals)
    val ans = TreeNode(0)
    var cur: TreeNode? = ans
    for (value in vals) {
        cur?.right = TreeNode(value ?: 0)
        cur = cur?.right
    }
    return ans.right
}

internal fun inorder(node: TreeNode?, vals: MutableList<Int?>) {
    if (node == null) return
    inorder(node.left, vals)
    vals.add(node.value)
    inorder(node.right, vals)
}
