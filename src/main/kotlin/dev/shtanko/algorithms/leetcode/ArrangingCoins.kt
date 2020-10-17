package dev.shtanko.algorithms.leetcode

import kotlin.math.sqrt

interface ArrangingCoinsStrategy {
    fun arrangeCoins(n: Int): Int
}

class ArrangingCoinsBS : ArrangingCoinsStrategy {
    override fun arrangeCoins(n: Int): Int {
        var left = 0
        var right = n
        var k: Int
        var curr: Int

        while (left <= right) {
            k = left + right.minus(left) / 2
            curr = k * k.plus(1) / 2
            if (curr == n) return k
            if (n < curr) {
                right = k - 1
            } else {
                left = k + 1
            }
        }
        return right
    }
}

class ArrangingCoinsMath : ArrangingCoinsStrategy {

    companion object {
        private const val C1 = 2
        private const val C2 = 0.25
        private const val C3 = 0.5
    }

    override fun arrangeCoins(n: Int): Int {
        val local = sqrt(C1 * n + C2) - C3
        return local.toInt()
    }
}
