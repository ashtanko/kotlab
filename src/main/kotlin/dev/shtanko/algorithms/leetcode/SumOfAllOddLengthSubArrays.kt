package dev.shtanko.algorithms.leetcode

interface SumOfAllOddLengthSubArraysStrategy {
    fun perform(arr: IntArray): Int
}

class SumOfAllOddLengthSubArraysSF : SumOfAllOddLengthSubArraysStrategy {
    override fun perform(arr: IntArray): Int {
        var res = 0
        val n: Int = arr.size
        for (i in 0 until n) {
            val local = i.plus(1) * n.minus(i) + 1
            res += local / 2 * arr[i]
        }
        return res
    }
}
