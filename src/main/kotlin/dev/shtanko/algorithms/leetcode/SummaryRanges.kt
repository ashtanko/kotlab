package dev.shtanko.algorithms.leetcode

import java.util.LinkedList

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 */
fun IntArray.summaryRanges(): List<String> {
    val range: MutableList<String> = LinkedList()
    var i = 0
    while (i < size) {
        val a = this[i]
        while (i + 1 < size && this[i + 1] - this[i] == 1) i++
        range.add(a.toString() + if (a == this[i]) "" else "->" + this[i])
        i++
    }
    return range
}
