package dev.shtanko.algorithms.leetcode

fun IntArray.singleNumber(): Int {
    var res = 0
    var i = 0
    while (i < this.size) {
        res = res xor this[i++]
    }
    return res
}

fun IntArray.singleNumberUsingSet(): Int {
    val set = HashSet<Int>()
    for (i in this) {
        if (!set.remove(i)) set.add(i)
    }
    return set.iterator().next()
}
