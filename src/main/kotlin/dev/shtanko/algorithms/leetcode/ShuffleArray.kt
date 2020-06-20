package dev.shtanko.algorithms.leetcode

/**
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 */
fun IntArray.shuffle(n: Int): IntArray {
    for (i in n until 2 * n) {
        this[i] = this[i] shl HEXADECIMAL
        this[i] = this[i] or this[i - n]
    }
    var i = 0
    while (i < 2 * n) {
        this[i] = this[n + i / 2] and SHUFFLE_CONST
        this[i + 1] = this[n + i / 2] shr HEXADECIMAL
        i += 2
    }
    return this
}
