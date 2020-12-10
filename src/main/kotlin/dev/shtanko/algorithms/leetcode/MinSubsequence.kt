package dev.shtanko.algorithms.leetcode

import java.util.Collections
import java.util.PriorityQueue

interface MinSubsequenceStrategy {
    fun perform(arr: IntArray): List<Int>
}

/**
 * Counting sort since the values are in [1, 100]
 * O(n) time
 * O(n) space
 */
class MinSubsequenceCountingSort : MinSubsequenceStrategy {

    override fun perform(arr: IntArray): List<Int> {
        val count = IntArray(ARR_SIZE)
        var totalSum = 0
        for (current in arr) {
            totalSum += current
            count[current]++
        }
        val currentSubseq = mutableListOf<Int>()
        var currSum = 0
        var i = count.size - 1
        while (i >= 0) {
            while (count[i] > 0) {
                currentSubseq.add(i)
                currSum += i
                count[i]--
                if (currSum > totalSum - currSum) {
                    i = -1
                    break
                }
            }
            --i
        }
        return currentSubseq
    }

    companion object {
        private const val ARR_SIZE = 101
    }
}

class MinSubsequencePriorityQueue : MinSubsequenceStrategy {
    override fun perform(arr: IntArray): List<Int> {
        return arr.solve()
    }

    private fun IntArray.solve(): List<Int> {
        val res = mutableListOf<Int>()

        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        var subSum = 0
        var totalSum = 0
        for (num in this) {
            pq.offer(num)
            totalSum += num
        }
        while (subSum <= totalSum / 2) {
            res.add(pq.peek())
            subSum += pq.poll()
        }
        return res
    }
}
