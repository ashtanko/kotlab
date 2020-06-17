package dev.shtanko.algorithms.leetcode

import kotlin.experimental.and
import kotlin.experimental.or

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Time complexity: O(N^2), memory: O(1)
 */
fun IntArray.isContainsDuplicateBrutForce(): Boolean {
    for (i in 0 until size) {
        for (j in i + 1 until size) {
            if (this[i] == this[j]) return true
        }
    }
    return false
}

/**
 * Time complexity: O(N lg N), memory: O(1) - not counting the memory used by sort
 */
fun IntArray.isContainsDuplicateSort(): Boolean {
    sort()
    for (i in 0 until size - 1) {
        if (this[i] == this[i + 1]) return true
    }
    return false
}

/**
 * Time complexity: O(N), memory: O(N)
 */
fun IntArray.isContainsDuplicateSimpleSet(): Boolean {
    return toHashSet().size < size
}

fun IntArray.isContainsDuplicateSet(): Boolean {
    val set = hashSetOf<Int>()

    for (i in 0 until size) {
        if (set.contains(this[i])) return true
        set.add(this[i])
    }

    return false
}

fun IntArray.isContainsDuplicateSet2(): Boolean {
    val set = hashSetOf<Int>()

    for (i in indices) {
        if (!set.add(this[i])) return true
    }

    return false
}

private const val ARR_SIZE = 150000

fun IntArray.isContainsDuplicateBitManipulation(): Boolean {
    val mark = ByteArray(ARR_SIZE)
    for (i in this) {
        val j = i / OCTAL
        val k = i % OCTAL
        val check = 1 shl k
        if (mark[j] and check.toByte() != 0.toByte()) {
            return true
        }
        mark[j] = mark[j] or check.toByte()
    }
    return false
}
