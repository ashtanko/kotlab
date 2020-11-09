package dev.shtanko.algorithms.leetcode

import java.util.LinkedList

internal fun TreeNode?.levelOrderBottom(): List<List<Int>> {
    val wrapList: MutableList<MutableList<Int>> = LinkedList()
    levelMaker(wrapList, this, 0)
    return wrapList
}

private fun levelMaker(list: MutableList<MutableList<Int>>, root: TreeNode?, level: Int) {
    if (root == null) return
    if (level >= list.size) {
        list.add(0, LinkedList())
    }
    levelMaker(list, root.left, level + 1)
    levelMaker(list, root.right, level + 1)
    list[list.size - level - 1].add(root.value)
}
