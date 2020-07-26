package dev.shtanko.algorithms.leetcode

fun Pair<Int, Int>.selfDividingNumbers(): List<Int> {
    val list: MutableList<Int> = ArrayList()
    var i = first
    while (i <= second) {
        if (i.isValid()) {
            list.add(i)
        }
        i++
    }
    return list
}

private fun Int.isValid(): Boolean {
    var cur = this
    while (cur != 0) {
        val digit = cur % DECIMAL
        if (digit == 0 || this % digit != 0) {
            return false
        }
        cur /= DECIMAL
    }
    return true
}
