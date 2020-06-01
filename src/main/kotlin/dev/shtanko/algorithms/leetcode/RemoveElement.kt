package dev.shtanko.algorithms.leetcode

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the
 * input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
fun IntArray.removeElement(elem: Int): Int {
    var count = 0
    if (!this.contains(elem)) return this.size
    for (num in this) {
        if (num != elem) {
            this[count] = num
            count++
        }
    }
    return count
}
