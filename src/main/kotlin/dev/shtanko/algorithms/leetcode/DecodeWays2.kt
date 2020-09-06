package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.lessThanZero
import dev.shtanko.algorithms.leetcode.DecodeWays2Strategy.Companion.FIFTEEN
import dev.shtanko.algorithms.leetcode.DecodeWays2Strategy.Companion.NINE
import dev.shtanko.algorithms.leetcode.DecodeWays2Strategy.Companion.SIX

interface DecodeWays2Strategy {
    fun perform(s: String): Int

    companion object {
        const val NINE = 9
        const val SIX = 6
        const val FIFTEEN = 15
    }
}

class DecodeWays2RecursionWithMemoization : DecodeWays2Strategy {
    private var m = 1000000007

    override fun perform(s: String): Int {
        val memo = arrayOfNulls<Int>(s.length)
        return ways(s, s.length - 1, memo)
    }

    private fun ways(s: String, i: Int, memo: Array<Int?>): Int {
        if (i.lessThanZero()) return 1
        if (memo[i] != null) return memo[i] ?: 1
        if (s[i] == '*') {
            var res = NINE * ways(s, i - 1, memo).toLong()
            if (i > 0 && s[i - 1] == '1') res =
                (res + NINE * ways(s, i - 2, memo)) % m else if (i > 0 && s[i - 1] == '2') res =
                (res + SIX * ways(s, i - 2, memo)) % m else if (i > 0 && s[i - 1] == '*') res =
                (res + FIFTEEN * ways(s, i - 2, memo)) % m
            memo[i] = res.toInt()
            return memo[i] ?: 1
        }
        var res = if (s[i] != '0') ways(s, i - 1, memo).toLong() else 0.toLong()
        if (i > 0 && s[i - 1] == '1') res =
            (res + ways(s, i - 2, memo)) % m else if (i > 0 && s[i - 1] == '2' && s[i] <= '6') res =
            (res + ways(s, i - 2, memo)) % m else if (i > 0 && s[i - 1] == '*') res =
            (res + (if (s[i] <= '6') 2 else 1) * ways(s, i - 2, memo)) % m
        memo[i] = res.toInt()
        return memo[i] ?: 1
    }
}

class DecodeWays2DynamicProgramming : DecodeWays2Strategy {
    private var m = 1000000007
    override fun perform(s: String): Int {
        val dp = LongArray(s.length + 1)
        dp[0] = 1
        dp[1] = if (s[0] == '*') NINE.toLong() else if (s[0] == '0') 0 else 1L
        for (i in 1 until s.length) {
            if (s[i] == '*') {
                dp[i + 1] = NINE * dp[i]
                when {
                    s[i - 1] == '1' -> dp[i + 1] = (dp[i + 1] + NINE * dp[i - 1]) % m
                    s[i - 1] == '2' -> dp[i + 1] =
                        (dp[i + 1] + SIX * dp[i - 1]) % m
                    s[i - 1] == '*' -> dp[i + 1] =
                        (dp[i + 1] + FIFTEEN * dp[i - 1]) % m
                }
            } else {
                dp[i + 1] = if (s[i] != '0') dp[i] else 0
                if (s[i - 1] == '1') dp[i + 1] =
                    (dp[i + 1] + dp[i - 1]) % m else if (s[i - 1] == '2' && s[i] <= '6') dp[i + 1] =
                    (dp[i + 1] + dp[i - 1]) % m else if (s[i - 1] == '*') dp[i + 1] =
                    (dp[i + 1] + (if (s[i] <= '6') 2 else 1) * dp[i - 1]) % m
            }
        }
        return dp[s.length].toInt()
    }
}

class DecodeWays2ConstantSpaceDynamicProgramming : DecodeWays2Strategy {
    private var m = 1000000007

    override fun perform(s: String): Int {
        var first: Long = 1
        var second = if (s[0] == '*') NINE.toLong() else if (s[0] == '0') 0 else 1.toLong()
        for (i in 1 until s.length) {
            val temp = second
            if (s[i] == '*') {
                second *= NINE
                when {
                    s[i - 1] == '1' -> second = (second + NINE * first) % m
                    s[i - 1] == '2' -> second =
                        (second + SIX * first) % m
                    s[i - 1] == '*' -> second = (second + FIFTEEN * first) % m
                }
            } else {
                second = if (s[i] != '0') second else 0
                if (s[i - 1] == '1') second = (second + first) % m else if (s[i - 1] == '2' && s[i] <= '6') second =
                    (second + first) % m else if (s[i - 1] == '*') second =
                    (second + (if (s[i] <= '6') 2 else 1) * first) % m
            }
            first = temp
        }
        return second.toInt()
    }
}
