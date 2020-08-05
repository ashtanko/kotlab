package dev.shtanko.algorithms.leetcode

fun String?.longestPalindrome(): String {
    if (this == null || this.isEmpty()) {
        return ""
    }
    val len = this.length
    val dp = Array(len) { BooleanArray(len) }
    var start = 0
    var end = 0
    var max = 0
    for (i in this.indices) {
        for (j in 0..i) {
            if (this[i] == this[j] && (i - j <= 2 || dp[j + 1][i - 1])) {
                dp[j][i] = true
            }
            if (dp[j][i] && max < i - j + 1) {
                max = i - j + 1
                start = j
                end = i
            }
        }
    }
    return this.substring(start, end + 1)
}
