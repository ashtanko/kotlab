package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import kotlin.math.max

class MostFrequentSubtreeSum {
    private val count: MutableMap<Int, Int> = HashMap()
    private var maxCount = 0

    fun perform(root: TreeNode?): IntArray {
        dfs(root)
        val res: MutableList<Int> = ArrayList()
        for (s in count.keys) {
            if (count[s] == maxCount) res.add(s)
        }
        return res.stream().mapToInt { i: Int -> i }.toArray()
    }

    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        val s: Int = dfs(root.left) + dfs(root.right) + root.value
        count[s] = count.getOrDefault(s, 0) + 1
        maxCount = max(maxCount, count[s]!!)
        return s
    }
}
