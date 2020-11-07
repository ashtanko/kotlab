package dev.shtanko.algorithms.leetcode

interface ConsecutiveCharactersStrategy {
    fun perform(s: String): Int
}

class MaxPower1 : ConsecutiveCharactersStrategy {
    override fun perform(s: String): Int {
        val n = s.length
        var start = 0
        var end = 0
        var max = 0
        while (end < n) {
            while (end < n && s[end] == s[start]) {
                max = max.coerceAtLeast(end - start + 1)
                end++
            }
            if (end == n) return max
            start = end
        }
        return max
    }
}

class MaxPower2 : ConsecutiveCharactersStrategy {
    override fun perform(s: String): Int {
        var res = 0
        val n = s.length
        var i = 0
        while (i < n) {
            val j = i
            while (i + 1 < n && s[i] == s[i + 1]) {
                i++
            }
            res = kotlin.math.max(i - j + 1, res)
            i++
        }
        return res
    }
}
