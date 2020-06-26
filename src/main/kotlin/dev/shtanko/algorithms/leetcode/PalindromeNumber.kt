package dev.shtanko.algorithms.leetcode

/**
 * Complexity Analysis
 * Time complexity : O(\log_{10}(n))O(log10(n)).
 * We divided the input by 10 for every iteration, so the time complexity is O(\log_{10}(n))O(log10(n))
 * Space complexity : O(1)O(1)
 */
fun Int.isPalindrome(): Boolean {
    var x = this
    val local = (x != 0 && x % DECIMAL == 0)
    if (x < 0 || local) return false

    var revertedNumber = 0
    while (x > revertedNumber) {
        revertedNumber = revertedNumber * DECIMAL + x % DECIMAL
        x /= DECIMAL
    }
    return (x == revertedNumber || x == revertedNumber / DECIMAL)
}
