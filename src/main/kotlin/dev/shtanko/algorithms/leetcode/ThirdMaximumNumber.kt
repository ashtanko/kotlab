package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue

private const val MAX = 3

fun thirdMax(nums: IntArray): Int {
    val pq: PriorityQueue<Int> = PriorityQueue()
    val set: MutableSet<Int> = HashSet()
    for (n in nums) {
        if (set.add(n)) {
            pq.offer(n)
            if (pq.size > MAX) pq.poll()
        }
    }
    if (pq.size == 2) pq.poll()
    return pq.peek()
}
