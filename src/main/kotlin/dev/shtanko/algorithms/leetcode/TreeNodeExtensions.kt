package dev.shtanko.algorithms.leetcode

// Function to insert nodes in level order
internal fun insertLevelOrder(rootNode: TreeNode?, arr: IntArray, i: Int): TreeNode? {
    var root: TreeNode? = rootNode

    // Base case for recursion
    if (i < arr.size) {
        val temp = TreeNode(arr[i])
        root = temp

        // insert left child
        root.left = insertLevelOrder(root.left, arr, 2 * i + 1)

        // insert right child
        root.right = insertLevelOrder(root.right, arr, 2 * i + 2)
    }

    return root
}
