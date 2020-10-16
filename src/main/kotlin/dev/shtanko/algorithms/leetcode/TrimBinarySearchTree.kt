package dev.shtanko.algorithms.leetcode

internal fun trimBST(root: TreeNode?, low: Int, high: Int): TreeNode? {
    if (root == null) return root
    if (root.value > high) return trimBST(root.left, low, high)
    if (root.value < low) return trimBST(root.right, low, high)

    root.left = trimBST(root.left, low, high)
    root.right = trimBST(root.right, low, high)
    return root
}
