package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.FindLuckyStrategy.Companion.MAX_ARR_SIZE

interface FindLuckyStrategy {

    companion object {
        const val MAX_ARR_SIZE = 500
    }

    fun perform(arr: IntArray): Int
}

class FindLuckyStraightForward : FindLuckyStrategy {
    override fun perform(arr: IntArray): Int {
        val cnt = IntArray(MAX_ARR_SIZE + 1)
        for (a in arr) {
            ++cnt[a]
        }
        for (i in MAX_ARR_SIZE downTo 1) {
            if (cnt[i] == i) {
                return i
            }
        }
        return -1
    }
}

class FindLuckyMap : FindLuckyStrategy {
    override fun perform(arr: IntArray): Int {
        val freq: MutableMap<Int, Int> = HashMap()
        for (a in arr) {
            freq[a] = 1 + freq.getOrDefault(a, 0) // Accumulate the occurrence of a.
        }
        var ans = -1
        for ((key, value) in freq) {
            if (key == value) {
                ans = ans.coerceAtLeast(key)
            }
        }
        return ans
    }
}
