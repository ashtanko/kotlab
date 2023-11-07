package dev.shtanko.algorithms.leetcode

import java.util.PriorityQueue

/**
 * 1921. Eliminate Maximum Number of Monsters
 * @see <a href="https://leetcode.com/problems/eliminate-maximum-number-of-monsters">Source</a>
 */
fun interface EliminateMaxNumOfMonsters {
    operator fun invoke(dist: IntArray, speed: IntArray): Int
}

sealed interface EliminateMaximumStrategy {

    /**
     * Approach 1: Sort By Arrival Time
     */
    data object Sort : EliminateMaxNumOfMonsters, EliminateMaximumStrategy {
        override fun invoke(dist: IntArray, speed: IntArray): Int {
            val arrival = DoubleArray(dist.size)
            for (i in dist.indices) {
                arrival[i] = dist[i].toDouble() / speed[i]
            }

            arrival.sort()
            var ans = 0

            for (i in arrival.indices) {
                if (arrival[i] <= i) {
                    break
                }
                ans++
            }

            return ans
        }
    }

    /**
     * Approach 2: Heap
     */
    data object Heap : EliminateMaxNumOfMonsters, EliminateMaximumStrategy {
        override fun invoke(dist: IntArray, speed: IntArray): Int {
            val heap: PriorityQueue<Double> = PriorityQueue()
            for (i in dist.indices) {
                heap.add(dist[i].toDouble() / speed[i])
            }

            var ans = 0
            while (!heap.isEmpty()) {
                if (heap.remove() <= ans) {
                    break
                }
                ans++
            }

            return ans
        }
    }
}
