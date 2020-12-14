package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue

/**
 * Time complexity : O(NlogN).
 * Space complexity : O(N).
 */
class MinimumCostToConnectSticks {
    fun connectSticks(sticks: IntArray): Int {
        var totalCost = 0
        val pq: PriorityQueue<Int> = PriorityQueue()
        // add all sticks to the min heap.
        for (stick in sticks) {
            pq.add(stick)
        }

        // combine two of the smallest sticks until we are left with just one.
        while (pq.size > 1) {
            val stick1: Int = pq.remove()
            val stick2: Int = pq.remove()
            val cost = stick1 + stick2
            totalCost += cost
            pq.add(stick1 + stick2)
        }

        return totalCost
    }
}
