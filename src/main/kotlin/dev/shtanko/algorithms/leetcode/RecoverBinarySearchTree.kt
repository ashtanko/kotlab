package dev.shtanko.algorithms.leetcode

internal fun recoverTree(root: TreeNode?) {
    var rootNode = root
    var pre: TreeNode? = null
    var first: TreeNode? = null
    var second: TreeNode? = null
    // Morris Traversal
    var temp: TreeNode?
    while (rootNode != null) {
        if (rootNode.left != null) {
            // connect threading for root
            temp = rootNode.left
            while (temp!!.right != null && temp.right != rootNode) temp = temp.right
            // the threading already exists
            if (temp.right != null) {
                if (pre != null && pre.value > rootNode.value) {
                    if (first == null) {
                        first = pre
                        second = rootNode
                    } else {
                        second = rootNode
                    }
                }
                pre = rootNode
                temp.right = null
                rootNode = rootNode.right
            } else {
                // construct the threading
                temp.right = rootNode
                rootNode = rootNode.left
            }
        } else {
            if (pre != null && pre.value > rootNode.value) {
                if (first == null) {
                    first = pre
                    second = rootNode
                } else {
                    second = rootNode
                }
            }
            pre = rootNode
            rootNode = rootNode.right
        }
    }
    // swap two node values;
    if (first != null && second != null) {
        val t: Int = first.value
        first.value = second.value
        second.value = t
    }
}
