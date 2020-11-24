package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

// Beautiful Array @link https://leetcode.com/problems/beautiful-array/
class BeautifulArray {

    private val memo: MutableMap<Int, IntArray> by lazy {
        HashMap()
    }

    fun perform(n: Int): IntArray {
        var res = ArrayList<Int>()
        res.add(1)
        while (res.size < n) {
            val tmp = ArrayList<Int>()
            for (i in res) if (i * 2 - 1 <= n) tmp.add(i * 2 - 1)
            for (i in res) if (i * 2 <= n) tmp.add(i * 2)
            res = tmp
        }
        return res.stream().mapToInt { i: Int? -> i!! }.toArray()
    }

    fun divideAndConquer(n: Int): IntArray {
        if (memo.containsKey(n)) return memo[n] ?: intArrayOf()
        val ans = IntArray(n)
        if (n == 1) {
            ans[0] = 1
        } else {
            var t = 0
            // odds
            val odds = n.plus(1).div(2)
            for (x in divideAndConquer(odds)) {
                ans[t++] = 2.times(x).minus(1)
            }

            // evens
            val evens = n.div(2)
            for (x in divideAndConquer(evens)) {
                ans[t++] = 2.times(x)
            }
        }
        memo[n] = ans
        return ans
    }
}
