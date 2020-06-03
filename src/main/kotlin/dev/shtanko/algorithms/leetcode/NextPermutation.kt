package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.swap

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 */
fun IntArray.nextPermutation() {
    val n = this.size
    if (n < 2) return

    var index = n - 1
    while (index > 0) {
        if (this[index - 1] < this[index]) {
            break
        }
        index--
    }

    if (index == 0) {
        reverseSort(0, n - 1)
        return
    } else {
        val value = this[index - 1]
        var j = n - 1
        while (j > index) {
            if (this[j] > value) break
            j--
        }
        swap(j, index - 1)
        reverseSort(index, n - 1)
    }
}

private fun IntArray.reverseSort(start: Int, end: Int) {
    var i = start
    var j = end
    while (i < j) swap(i++, j--)
}
