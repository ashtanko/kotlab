package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.isEven
import dev.shtanko.algorithms.extensions.swap

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 */
fun IntArray.sortArrayByParity(): IntArray {
    var i = 0
    var j = size - 1
    while (i < j) {
        if (this[i].isEven) {
            i++
        } else {
            if (!this[j].isEven) {
                j--
            }
            if (this[j].isEven) {
                swap(i, j)
                i++
                j--
            }
        }
    }
    return this
}
