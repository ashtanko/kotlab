package dev.shtanko.algorithms.leetcode

interface PairSumStrategy {
    fun perform(arr: IntArray): Int
}

class PairSumSort1 : PairSumStrategy {
    override fun perform(arr: IntArray): Int {
        arr.sort()
        val list = arr.toList()
        val chunks = list.chunked(2)
        var res = 0
        for (chunk in chunks) {
            res += kotlin.math.min(chunk.first(), chunk.last())
        }
        return res
    }
}

class PairSumSort2 : PairSumStrategy {
    override fun perform(arr: IntArray): Int {
        arr.sort()
        var res = 0
        var i = 0
        while (i < arr.size) {
            res += arr[i]
            i += 2
        }
        return res
    }
}

class PairSumSort3 : PairSumStrategy {
    override fun perform(arr: IntArray): Int {
        arr.sort()
        return arr.toList().chunked(2) { it.minOrNull() ?: 0 }.sum()
    }
}

class PairSumOdd : PairSumStrategy {

    override fun perform(arr: IntArray): Int {
        val exist = IntArray(MAX_ARR_SIZE)
        for (i in arr.indices) {
            exist[arr[i] + ARR_HELPER]++
        }
        var sum = 0
        var isOdd = true
        for (i in exist.indices) {
            while (exist[i] > 0) {
                if (isOdd) {
                    sum += i - ARR_HELPER
                }
                isOdd = !isOdd
                exist[i]--
            }
        }
        return sum
    }

    companion object {
        private const val MAX_ARR_SIZE = 20001
        private const val ARR_HELPER = 10000
    }
}
