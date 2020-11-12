package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Queue

// Function to insert nodes in level order
internal fun insertLevelOrder(rootNode: TreeNode?, arr: IntArray, i: Int = 0): TreeNode? {
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

fun IntArray.toTree(): TreeNode? {
    if (isEmpty()) return null
    val root = TreeNode(first())
    val q: Queue<TreeNode> = LinkedList()
    q.add(root)

    for (i in 1 until this.size) {
        val node = q.peek()
        if (node.left == null) {
            node.left = TreeNode(this[i])
            q.add(node.left)
        } else if (node.right == null) {
            node.right = TreeNode(this[i])
            q.add(node.right)
            q.remove()
        }
    }
    return root
}
