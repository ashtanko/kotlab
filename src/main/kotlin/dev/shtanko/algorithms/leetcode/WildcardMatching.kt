package dev.shtanko.algorithms.leetcode

fun Pair<String, String>.isMatch(): Boolean {
    val m = first.length
    val n = second.length
    val ws = first.toCharArray()
    val wp = second.toCharArray()
    val dp =
        Array(m + 1) { BooleanArray(n + 1) }
    dp[0][0] = true
    for (j in 1..n) dp[0][j] = dp[0][j - 1] && wp[j - 1] == '*'
    for (i in 1..m) dp[i][0] = false
    for (i in 1..m) {
        for (j in 1..n) {
            if (wp[j - 1] == '?' || ws[i - 1] == wp[j - 1]) dp[i][j] =
                dp[i - 1][j - 1] else if (wp[j - 1] == '*') dp[i][j] =
                dp[i - 1][j] || dp[i][j - 1]
        }
    }
    return dp[m][n]
}
