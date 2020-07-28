package dev.shtanko.algorithms.leetcode

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList

internal fun TreeNode?.postOrderTraversal(): List<Int> {
    val result: LinkedList<Int> = LinkedList()
    val stack: Deque<TreeNode> = ArrayDeque()
    var p: TreeNode? = this
    while (stack.isNotEmpty() || p != null) {
        p = if (p != null) {
            stack.push(p)
            result.addFirst(p.value)
            p.right
        } else {
            val node = stack.pop()
            node.left
        }
    }
    return result
}
