package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Stack

internal fun TreeNode?.preorderTraversal(): List<Int> {
    val list: MutableList<Int> = LinkedList()
    val stack: Stack<TreeNode> = Stack()
    var node = this
    while (node != null) {
        list.add(node.value)
        if (node.right != null) {
            stack.push(node.right)
        }
        node = node.left
        if (node == null && stack.isNotEmpty()) {
            node = stack.pop()
        }
    }

    return list
}
