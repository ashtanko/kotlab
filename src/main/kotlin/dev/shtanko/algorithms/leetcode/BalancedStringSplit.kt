package dev.shtanko.algorithms.leetcode

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * Return the maximum amount of splitted balanced strings.
 */
fun String.balancedStringSplit(): Int {
    var c = 0
    var count = 0
    for (s in this) {
        count += if (s == 'L') 1 else -1
        if (count == 0) {
            c++
        }
    }
    return c
}
