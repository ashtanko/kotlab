package dev.shtanko.algorithms.leetcode

import java.util.Arrays
import java.util.PriorityQueue

fun Pair<Array<IntArray>, Int>.kClosest(): Array<IntArray> {
    var k = second
    val heap = PriorityQueue(Comparator<IntArray> { left, right -> right.getDistance() - left.getDistance() })
    for (point in first) {
        heap.add(point)
        if (heap.size > k) heap.poll()
    }
    val result = Array(k) { IntArray(2) }
    while (k > 0) result[--k] = heap.poll()
    return result
}

fun Pair<Array<IntArray>, Int>.kClosest2(): Array<IntArray> {
    val n = first.size
    val k = second
    val dists = IntArray(n)
    for (i in 0 until n) dists[i] = first[i].getDistance()
    Arrays.sort(dists)
    val distK = dists[k - 1]
    val ans = Array(k) { IntArray(2) }
    var t = 0
    for (i in 0 until n) if (first[i].getDistance() <= distK) ans[t++] = first[i]
    return ans
}

private fun IntArray.getDistance(): Int {
    return this[0] * this[0] + this[1] * this[1]
}
