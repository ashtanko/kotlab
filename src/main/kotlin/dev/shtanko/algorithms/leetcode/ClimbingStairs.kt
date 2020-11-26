package dev.shtanko.algorithms.leetcode

import kotlin.math.pow
import kotlin.math.sqrt

interface ClimbingStairsStrategy {
    fun perform(n: Int): Int
}

class ClimbingStairsBruteForce : ClimbingStairsStrategy {
    override fun perform(n: Int): Int {
        return climbStairs(0, n)
    }

    private fun climbStairs(i: Int, n: Int): Int {
        if (i > n) {
            return 0
        }
        return if (i == n) {
            1
        } else climbStairs(i + 1, n) + climbStairs(i + 2, n)
    }
}

class ClimbingStairsRecursionMemo : ClimbingStairsStrategy {
    override fun perform(n: Int): Int {
        val memo = IntArray(n + 1)
        return climbStairs(0, n, memo)
    }

    private fun climbStairs(i: Int, n: Int, memo: IntArray): Int {
        if (i > n) {
            return 0
        }
        if (i == n) {
            return 1
        }
        if (memo[i] > 0) {
            return memo[i]
        }
        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i + 2, n, memo)
        return memo[i]
    }
}

class ClimbingStairsDP : ClimbingStairsStrategy {
    override fun perform(n: Int): Int {
        if (n == 1) {
            return 1
        }
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 2
        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n]
    }
}

class ClimbingStairsFibonacci : ClimbingStairsStrategy {
    override fun perform(n: Int): Int {
        if (n == 1) {
            return 1
        }
        var first = 1
        var second = 2
        for (i in 3..n) {
            val third = first + second
            first = second
            second = third
        }
        return second
    }
}

class ClimbingStairsBinetsMethod : ClimbingStairsStrategy {
    override fun perform(n: Int): Int {
        val q = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
        val res = pow(q, n)
        return res[0][0]
    }

    private fun pow(arr: Array<IntArray>, s: Int): Array<IntArray> {
        var a = arr
        var n = s
        var ret: Array<IntArray> = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
        while (n > 0) {
            if (n and 1 == 1) {
                ret = multiply(ret, a)
            }
            n = n shr 1
            a = multiply(a, a)
        }
        return ret
    }

    private fun multiply(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
        val c = Array(2) { IntArray(2) }
        for (i in 0..1) {
            for (j in 0..1) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j]
            }
        }
        return c
    }
}

class ClimbingStairsFibonacciFormula : ClimbingStairsStrategy {

    companion object {
        private const val FIB_FORMULA_VALUE = 5.0
    }

    override fun perform(n: Int): Int {
        val sqrt5 = sqrt(FIB_FORMULA_VALUE)
        val firstPart = 1.plus(sqrt5).div(2).pow(n.plus(1).toDouble())
        val secondPart = 1.minus(sqrt5).div(2).pow((n + 1).toDouble())
        val fibN = firstPart - secondPart
        return fibN.div(sqrt5).toInt()
    }
}