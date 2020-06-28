package dev.shtanko.algorithms.leetcode

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears
 * more than ⌊ n/2 ⌋ times.
 */
fun IntArray.majorityElement(): Int {
    var major = this[0]

    var count = 1
    for (i in 1 until size) {
        when {
            count == 0 -> {
                count++
                major = this[i]
            }
            major == this[i] -> {
                count++
            }
            else -> {
                count--
            }
        }
    }

    return major
}
