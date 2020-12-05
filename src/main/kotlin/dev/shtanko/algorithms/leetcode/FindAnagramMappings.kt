package dev.shtanko.algorithms.leetcode

object FindAnagramMappings {
    fun perform(a: IntArray, b: IntArray): IntArray {
        val d: MutableMap<Int, Int> = HashMap()
        for (i in b.indices) d[b[i]] = i

        val ans = IntArray(a.size)
        var t = 0
        for (x in a) ans[t++] = d[x]!!
        return ans
    }
}
