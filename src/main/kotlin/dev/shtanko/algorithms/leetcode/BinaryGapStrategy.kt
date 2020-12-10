package dev.shtanko.algorithms.leetcode

private const val MAX_SIZE = 32

interface BinaryGapStrategy {
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

class BGOther : BinaryGapStrategy {
    override fun binaryGap(n: Int): Int {
        var max = 0
        var pos = 0
        var lastPos = -1
        var changed = n
        while (changed != 0) {
            pos++
            if (changed and 1 == 1) {
                if (lastPos != -1) {
                    max = max.coerceAtLeast(pos - lastPos)
                }
                lastPos = pos
            }
            changed = changed shr 1
        }
        return max
    }
}
