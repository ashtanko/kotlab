package dev.shtanko.algorithms.leetcode

/**
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange,
 * and ans[1] is the size of the candy bar that Bob must exchange. If there are multiple answers,
 * you may return any one of them.  It is guaranteed an answer exists.
 */
fun Pair<IntArray, IntArray>.fairCandySwap(): IntArray {
    val difSum = first.sum() - second.sum()
    val dif = difSum / 2
    val set: MutableSet<Int> = HashSet()
    for (a in first) {
        set.add(a)
    }
    for (b in second) {
        if (set.contains(b + dif)) return intArrayOf(b + dif, b)
    }
    return intArrayOf()
}
