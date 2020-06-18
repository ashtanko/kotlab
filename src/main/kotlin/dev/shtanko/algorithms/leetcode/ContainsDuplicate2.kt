package dev.shtanko.algorithms.leetcode

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
fun IntArray.isContainsNearbyDuplicate(k: Int): Boolean {
    val set = hashSetOf<Int>()
    for (i in indices) {
        if (i > k) {
            set.remove(this[i - k - 1])
        }
        if (!set.add(this[i])) return true
    }
    return false
}
