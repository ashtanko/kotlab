package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue

interface LastStoneWeightStrategy {
    fun perform(arr: IntArray): Int
}

class LastStoneWeightSort : LastStoneWeightStrategy {
    override fun perform(arr: IntArray): Int {
        return arr.lastStoneWeight()
    }

    private fun IntArray.lastStoneWeight(): Int {
        sort()
        for (i in size - 1 downTo 1) {
            this[i - 1] = this[i] - this[i - 1]
            sort()
        }
        return first()
    }
}

class LastStoneWeightQueue : LastStoneWeightStrategy {
    override fun perform(arr: IntArray): Int {
        val pq = PriorityQueue<Int> { c, d -> d - c }
        for (stone in arr) {
            pq.offer(stone)
        }
        while (pq.size > 1) {
            pq.offer(pq.poll() - pq.poll())
        }
        return pq.poll()
    }
}
