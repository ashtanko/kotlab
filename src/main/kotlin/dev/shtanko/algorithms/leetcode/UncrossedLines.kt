package dev.shtanko.algorithms.leetcode

fun Pair<IntArray, IntArray>.maxUncrossedLines(): Int {
    val m = first.size
    val n = second.size
    val dp = Array(m + 1) { IntArray(n + 1) }
    for (i in 1..m) for (j in 1..n) if (first[i - 1] == second[j - 1]) dp[i][j] =
        1 + dp[i - 1][j - 1] else dp[i][j] =
        dp[i][j - 1].coerceAtLeast(dp[i - 1][j])
    return dp[m][n]
}
