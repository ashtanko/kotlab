package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.LinkedList
import java.util.Queue

internal interface AverageOfLevelsInBinaryTreeStrategy {
    fun perform(root: TreeNode?): DoubleArray
}

// Using Depth First Search
internal class AverageOfLevelsInBinaryTreeDFS : AverageOfLevelsInBinaryTreeStrategy {
    override fun perform(root: TreeNode?): DoubleArray {
        val count: MutableList<Int> = ArrayList()
        val res: MutableList<Double> = ArrayList()
        average(root, 0, res, count)
        for (i in res.indices) res[i] = res[i] / count[i]
        return res.toDoubleArray()
    }

    fun average(t: TreeNode?, i: Int, sum: MutableList<Double>, count: MutableList<Int>) {
        if (t == null) return
        if (i < sum.size) {
            sum[i] = sum[i] + t.value
            count[i] = count[i] + 1
        } else {
            sum.add(1.0 * t.value)
            count.add(1)
        }
        average(t.left, i + 1, sum, count)
        average(t.right, i + 1, sum, count)
    }
}

// Using Breadth First Search
internal class AverageOfLevelsInBinaryTreeBFS : AverageOfLevelsInBinaryTreeStrategy {
    override fun perform(root: TreeNode?): DoubleArray {
        val res: MutableList<Double> = ArrayList()
        var queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        while (!queue.isEmpty()) {
            var sum: Long = 0
            var count: Long = 0
            val temp: Queue<TreeNode?> = LinkedList()
            while (!queue.isEmpty()) {
                val n: TreeNode? = queue.remove()
                if (n != null) {
                    sum += n.value
                    count++
                    if (n.left != null) temp.add(n.left)
                    if (n.right != null) temp.add(n.right)
                }
            }
            queue = temp
            res.add(sum * 1.0 / count)
        }
        return res.toDoubleArray()
    }
}
