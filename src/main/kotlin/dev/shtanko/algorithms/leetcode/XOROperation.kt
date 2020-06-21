package dev.shtanko.algorithms.leetcode

/**
 * Given an integer n and an integer start.
 * Define an array nums where nums[i] = start + 2*i (0-indexed) and n == nums.length.
 * Return the bitwise XOR of all elements of nums.
 */
fun Int.xorOperation(start: Int): Int {
    var xor = 0
    for (i in 0 until this) {
        xor = xor xor start + 2 * i
    }
    return xor
}
