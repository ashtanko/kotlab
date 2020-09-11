package dev.shtanko.algorithms.leetcode

interface SuperEggDropStrategy {
    fun perform(eggs: Int, floors: Int): Int
}

class SuperEggDropDPBinarySearch : SuperEggDropStrategy {

    private var memo: MutableMap<Int, Int?> = HashMap()

    companion object {
        private const val HUNDRED = 100
    }

    override fun perform(eggs: Int, floors: Int): Int {
        return calculate(eggs, floors)
    }

    private fun calculate(eggs: Int, floors: Int): Int {
        if (!memo.containsKey(floors * HUNDRED + eggs)) {
            val ans: Int
            when {
                floors == 0 -> ans = 0
                eggs == 1 -> ans = floors
                else -> {
                    var lo = 1
                    var hi = floors
                    while (lo + 1 < hi) {
                        val x = (lo + hi) / 2
                        val t1 = calculate(eggs - 1, x - 1)
                        val t2 = calculate(eggs, floors - x)
                        when {
                            t1 < t2 -> lo = x
                            t1 > t2 -> hi = x
                            else -> {
                                hi = x
                                lo = hi
                            }
                        }
                    }
                    ans = 1 + calculate(eggs - 1, lo - 1).coerceAtLeast(calculate(eggs, floors - lo))
                        .coerceAtMost(calculate(eggs - 1, hi - 1).coerceAtLeast(calculate(eggs, floors - hi)))
                }
            }
            memo[floors * HUNDRED + eggs] = ans
        }
        return memo[floors * HUNDRED + eggs]!!
    }
}

class SuperEggDropDPOptimalityCriterion : SuperEggDropStrategy {
    override fun perform(eggs: Int, floors: Int): Int {
        // Right now, dp[i] represents dp(1, i)
        // Right now, dp[i] represents dp(1, i)
        var dp = IntArray(floors + 1)
        for (i in 0..floors) dp[i] = i

        for (i in 2..eggs) {
            // Now, we will develop dp2[i] = dp(k, i)
            val dp2 = IntArray(floors + 1)
            var x = 1
            for (j in 1..floors) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < j && dp[x - 1].coerceAtLeast(dp2[j - x]) > dp[x].coerceAtLeast(dp2[j - x - 1])
                ) x++

                // The final answer happens at this x.
                dp2[j] = 1 + dp[x - 1].coerceAtLeast(dp2[j - x])
            }
            dp = dp2
        }

        return dp[floors]
    }
}

class SuperEggDropMathematical : SuperEggDropStrategy {
    override fun perform(eggs: Int, floors: Int): Int {
        var lo = 1
        var hi: Int = floors
        while (lo < hi) {
            val mi = (lo + hi) / 2
            if (calculate(mi, eggs, floors) < floors) lo = mi + 1 else hi = mi
        }

        return lo
    }

    fun calculate(x: Int, eggs: Int, floors: Int): Int {
        var ans = 0
        var res = 1
        for (i in 1..eggs) {
            res *= x - i + 1
            res /= i
            ans += res
            if (ans >= floors) break
        }
        return ans
    }
}
