package dev.shtanko.algorithms.leetcode

/**
 * Given the array of integers nums, you will choose two different indices i and j of that array.
 * Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */
fun IntArray.maxProduct(): Int {
    var m = Int.MIN_VALUE
    var n = m
    for (num in this) {
        if (num >= m) {
            n = m
            m = num
        } else if (num > n) {
            n = num
        }
    }
    return m.minus(1) * n.minus(1)
}
