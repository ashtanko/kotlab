package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue

fun IntArray.lastStoneWeight(): Int {
    sort()
    for (i in size - 1 downTo 1) {
        this[i - 1] = this[i] - this[i - 1]
        sort()
    }
    return first()
}

fun IntArray.lastStoneWeightQueue(): Int {
    val pq = PriorityQueue<Int> { c, d -> d - c }
    for (stone in this) {
        pq.offer(stone)
    }
    while (pq.size > 1) {
        pq.offer(pq.poll() - pq.poll())
    }
    return pq.poll()
}
