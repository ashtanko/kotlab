package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import kotlin.math.min

class MinimumCostToCutStick {

    fun perform(n: Int, cuts: IntArray): Int {
        val c = ArrayList<Int>()
        for (cut in cuts) c.add(cut)
        c.addAll(listOf(0, n))
        c.sort()
        val dp = Array(c.size) { IntArray(c.size) }
        for (i in c.indices.reversed()) for (j in i + 1 until c.size) {
            for (k in i + 1 until j) dp[i][j] = min(
                if (dp[i][j] == 0) Int.MAX_VALUE else dp[i][j],
                c[j] - c[i] + dp[i][k] + dp[k][j]
            )
        }
        return dp[0][c.size - 1]
    }
}
