package dev.shtanko.algorithms.leetcode

import java.util.LinkedList

@ExperimentalStdlibApi
private fun backtrack(
    remain: Int,
    comb: MutableList<Int>,
    start: Int,
    candidates: IntArray,
    results: MutableList<List<Int>>
) {
    if (remain == 0) {
        results.add(ArrayList(comb))
        return
    } else if (remain < 0) {
        return
    }
    for (i in start until candidates.size) {
        comb.add(candidates[i])
        backtrack(remain - candidates[i], comb, i, candidates, results)
        comb.removeLast()
    }
}

@ExperimentalStdlibApi
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val results = ArrayList<List<Int>>()
    val comb = LinkedList<Int>()
    backtrack(target, comb, 0, candidates, results)
    return results
}
