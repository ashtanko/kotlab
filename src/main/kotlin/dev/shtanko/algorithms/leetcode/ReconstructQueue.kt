package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.extensions.second
import java.util.Arrays
import java.util.LinkedList

fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    Arrays.sort(people) { a, b -> if (a.first() == b.first()) a.second() - b.second() else b.first() - a.first() }
    val list: MutableList<IntArray> = LinkedList()
    for (p in people) {
        list.add(p.second(), p)
    }
    return list.toTypedArray()
}
