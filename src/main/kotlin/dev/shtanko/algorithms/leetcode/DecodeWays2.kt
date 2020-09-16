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
            memo[i] = getRes(s, i, memo)
            return memo[i] ?: 1
        }
        var res = if (s[i] != '0') ways(s, i - 1, memo).toLong() else 0L
        if (i > 0) {
            res = when (s[i - 1]) {
                '1' -> justCalculateRes(s, i, memo, res)
                '2' -> {
                    if (s[i] <= '6') {
                        justCalculateRes(s, i, memo, res)
                    } else {
                        res
                    }
                }
                '*' -> {
                    val r = if (s[i] <= '6') 2 else 1
                    calculateRes(s, i, memo, res, r)
                }
                else -> res
            }
        }
        memo[i] = res.toInt()
        return memo[i] ?: 1
    }

    private fun getRes(s: String, i: Int, memo: Array<Int?>): Int {
        val j = i - 1
        var res = NINE * ways(s, j, memo).toLong()
        if (i > 0) {
            res = when (s[j]) {
                '1' -> calculateRes(s, i, memo, res, NINE)
                '2' -> calculateRes(s, i, memo, res, SIX)
                '*' -> calculateRes(s, i, memo, res, FIFTEEN)
                else -> {
                    res
                }
            }
        }
        return res.toInt()
    }

    private fun calculateRes(s: String, i: Int, memo: Array<Int?>, res: Long, value: Int): Long {
        val local = res + value * ways(s, i - 2, memo)
        return local % m
    }

    private fun justCalculateRes(s: String, i: Int, memo: Array<Int?>, res: Long): Long {
        val local = res + ways(s, i - 2, memo)
        return local % m
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
                calculateDP(dp, i, s)
            } else {
                dp[i + 1] = if (s[i] != '0') dp[i] else 0
                dp[i + 1] = when (s[i - 1]) {
                    '1' -> {
                        getDp(dp, i)
                    }
                    '2' -> {
                        if (s[i] <= '6') {
                            getDp(dp, i)
                        } else {
                            dp[i + 1]
                        }
                    }
                    '*' -> {
                        val local = if (s[i] <= '6') 2 else 1
                        val calculated = dp[i + 1] + local * dp[i - 1]
                        calculated % m
                    }
                    else -> {
                        dp[i + 1]
                    }
                }
            }
        }
        return dp[s.length].toInt()
    }

    private fun getDp(dp: LongArray, i: Int): Long {
        val local = dp[i + 1].plus(dp[i - 1])
        return local % m
    }

    private fun calculateDP(dp: LongArray, i: Int, s: String) {
        when (s[i - 1]) {
            '1' -> justCalculateDP(dp, i, NINE)
            '2' -> justCalculateDP(dp, i, SIX)
            '*' -> justCalculateDP(dp, i, FIFTEEN)
        }
    }

    private fun justCalculateDP(dp: LongArray, i: Int, value: Int) {
        dp[i + 1] = (dp[i + 1] + value * dp[i - 1]) % m
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
                second = calculateSecond(s, i, first, second)
            } else {
                second = if (s[i] != '0') second else 0
                second = when (s[i - 1]) {
                    '1' -> sumM(first, second)
                    '2' -> {
                        if (s[i] <= '6') {
                            sumM(first, second)
                        } else {
                            second
                        }
                    }
                    '*' -> {
                        val local = if (s[i] <= '6') 2 else 1
                        justCalculate(first, second, local)
                    }
                    else -> second
                }
            }
            first = temp
        }
        return second.toInt()
    }

    private fun sumM(first: Long, second: Long): Long {
        val sum = second.plus(first)
        return sum % m
    }

    private fun calculateSecond(s: String, i: Int, first: Long, second: Long): Long {
        return when (s[i - 1]) {
            '1' -> justCalculate(first, second, NINE)
            '2' -> justCalculate(first, second, SIX)
            '*' -> justCalculate(first, second, FIFTEEN)
            else -> second
        }
    }

    private fun justCalculate(first: Long, second: Long, value: Int): Long {
        val local = second + value * first
        return local % m
    }
}
