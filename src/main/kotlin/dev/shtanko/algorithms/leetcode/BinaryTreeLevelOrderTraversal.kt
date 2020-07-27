package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Queue

internal fun TreeNode?.levelOrder(): List<List<Int>> {
    val queue: Queue<TreeNode> = LinkedList()
    val wrapList: MutableList<MutableList<Int>> = ArrayList()
    if (this == null) return wrapList
    queue.offer(this)
    while (!queue.isEmpty()) {
        val levelNum = queue.size
        val subList: MutableList<Int> = LinkedList()
        for (i in 0 until levelNum) {
            if (queue.peek().left != null) {
                queue.offer(queue.peek().left)
            }
            if (queue.peek().right != null) {
                queue.offer(queue.peek().right)
            }
            subList.add(queue.poll().value)
        }
        wrapList.add(subList)
    }
    return wrapList
}
