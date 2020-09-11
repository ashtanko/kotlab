package dev.shtanko.algorithms.leetcode

fun isSubsequence(s: String, t: String): Boolean {
    val n = t.length
    val m = s.length
    var i = 0
    var j = 0
    while (i != n && j != m) {
        if (t[i] == s[j]) {
            i++
            j++
        } else {
            i++
        }
    }
    return j == m
}
