package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

class FindModeInBinarySearchTree {

    private var prev: Int? = null
    var count = 1
    var max = 0

    fun perform(root: TreeNode?): IntArray {
        if (root == null) return IntArray(0)

        val list: MutableList<Int> = ArrayList()
        traverse(root, list)

        val res = IntArray(list.size)
        for (i in list.indices) res[i] = list[i]
        return res
    }

    private fun traverse(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) return
        traverse(root.left, list)
        if (prev != null) {
            if (root.value == prev) count++ else count = 1
        }
        if (count > max) {
            max = count
            list.clear()
            list.add(root.value)
        } else if (count == max) {
            list.add(root.value)
        }
        prev = root.value
        traverse(root.right, list)
    }
}