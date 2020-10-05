package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.BinaryGapStrategy.Companion.MAX_SIZE

interface BinaryGapStrategy {

    companion object {
        const val MAX_SIZE = 32
    }

    fun binaryGap(n: Int): Int
}

class BGStoreIndexes : BinaryGapStrategy {

    override fun binaryGap(n: Int): Int {
        val a = IntArray(MAX_SIZE)
        var t = 0
        for (i in 0 until MAX_SIZE) if (n shr i and 1 != 0) a[t++] = i
        var ans = 0
        for (i in 0 until t - 1) ans = ans.coerceAtLeast(a[i + 1] - a[i])
        return ans
    }
}

class BGOnePass : BinaryGapStrategy {
    override fun binaryGap(n: Int): Int {
        var last = -1
        var ans = 0
        for (i in 0 until MAX_SIZE) if (n shr i and 1 > 0) {
            if (last >= 0) ans = ans.coerceAtLeast(i - last)
            last = i
        }

        return ans
    }
}
