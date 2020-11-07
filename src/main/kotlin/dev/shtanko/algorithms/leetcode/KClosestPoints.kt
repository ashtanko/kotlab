package dev.shtanko.algorithms.leetcode

import java.util.Arrays
import java.util.PriorityQueue

interface KClosestPointsStrategy {
    fun perform(points: Array<IntArray>, k: Int): Array<IntArray>

    fun IntArray.getDistance(): Int {
        return this[0] * this[0] + this[1] * this[1]
    }
}

class KClosestPointsQueue : KClosestPointsStrategy {
    override fun perform(points: Array<IntArray>, k: Int): Array<IntArray> {
        var n = k
        val heap = PriorityQueue(Comparator<IntArray> { left, right -> right.getDistance() - left.getDistance() })
        for (point in points) {
            heap.add(point)
            if (heap.size > n) heap.poll()
        }
        val result = Array(n) { IntArray(2) }
        while (n > 0) result[--n] = heap.poll()
        return result
    }
}

class KClosestPointsSort : KClosestPointsStrategy {
    override fun perform(points: Array<IntArray>, k: Int): Array<IntArray> {
        val n = points.size
        val dists = IntArray(n)
        for (i in 0 until n) dists[i] = points[i].getDistance()
        Arrays.sort(dists)
        val distK = dists[k - 1]
        val ans = Array(k) { IntArray(2) }
        var t = 0
        for (i in 0 until n) if (points[i].getDistance() <= distK) ans[t++] = points[i]
        return ans
    }
}
