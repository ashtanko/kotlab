package dev.shtanko.algorithms.leetcode

import java.util.LinkedList

fun IntArray.threeSum(): List<List<Int>> {
    sort()

    val result: MutableList<List<Int>> = LinkedList()
    for (i in 0 until this.size - 2) {
        if (i == 0 || (i > 0 && this[i] != this[i - 1])) {
            var lo = i + 1
            var hi = this.size - 1
            val sum = 0 - this[i]

            while (lo < hi) {
                when {
                    this[lo] + this[hi] == sum -> {
                        result.add(listOf(this[i], this[lo], this[hi]))
                        while (lo < hi && this[lo] == this[lo + 1]) lo++
                        while (lo < hi && this[hi] == this[hi - 1]) hi--
                        lo++
                        hi--
                    }
                    this[lo] + this[hi] < sum -> {
                        lo++
                    }
                    else -> {
                        hi--
                    }
                }
            }
        }
    }
    return result
}
