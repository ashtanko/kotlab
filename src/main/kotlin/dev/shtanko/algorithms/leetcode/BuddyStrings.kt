package dev.shtanko.algorithms.leetcode

/**
 * Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A
 * so that the result equals B.
 */
fun Pair<String, String>.buddyStrings(): Boolean {
    if (first.length != second.length) return false

    if (first == second) {
        val s = hashSetOf<Char>()
        for (c in first.toCharArray()) {
            s.add(c)
        }
        return s.size < first.length
    }
    val dif = mutableListOf<Int>()
    for (i in first.indices) {
        if (first[i] != second[i]) {
            dif.add(i)
        }
    }
    return dif.size == 2 && first[dif[0]] == second[dif[1]] && first[dif[1]] == second[dif[0]]
}
