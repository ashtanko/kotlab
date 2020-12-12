package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import kotlin.math.max

/**
 * Approach 1: Greedy
 * Time Complexity: O(N).
 * Space Complexity: O(1).
 */
class PartitionLabels {
    fun perform(s: String): List<Int> {
        val last = IntArray(MAX_SIZE)
        for (i in s.indices) {
            last[s[i] - 'a'] = i
        }
        var j = 0
        var anchor = 0
        val ans: MutableList<Int> = ArrayList()
        for (i in s.indices) {
            j = max(j, last[s[i] - 'a'])
            if (i == j) {
                ans.add(i - anchor + 1)
                anchor = i + 1
            }
        }
        return ans
    }

    companion object {
        private const val MAX_SIZE = 26
    }
}
