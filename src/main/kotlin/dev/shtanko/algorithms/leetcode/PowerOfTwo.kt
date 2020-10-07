package dev.shtanko.algorithms.leetcode

interface PowerOfTwoStrategy {
    fun isPowerOfTwo(n: Int): Boolean
}

class POTIterative : PowerOfTwoStrategy {
    override fun isPowerOfTwo(n: Int): Boolean {
        var num = n
        if (num <= 0) return false
        while (num % 2 == 0) num /= 2
        return num == 1
    }
}

class POTBitwise : PowerOfTwoStrategy {
    override fun isPowerOfTwo(n: Int): Boolean {
        return if (n < 1) false else 0 == n - 1 and n
    }
}
