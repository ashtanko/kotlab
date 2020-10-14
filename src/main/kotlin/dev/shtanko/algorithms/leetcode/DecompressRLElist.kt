package dev.shtanko.algorithms.leetcode

import java.util.ArrayList

fun IntArray.decompressRLEList(): IntArray {
    val list: MutableList<Int> = ArrayList()
    var i = 0
    while (i < size) {
        for (j in 0 until this[i]) {
            list.add(this[i + 1])
        }
        i += 2
    }

    val res = IntArray(list.size)
    for (j in list.indices) {
        res[j] = list[j]
    }
    return res
}
