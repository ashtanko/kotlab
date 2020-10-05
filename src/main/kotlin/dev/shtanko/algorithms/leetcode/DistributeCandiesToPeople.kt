package dev.shtanko.algorithms.leetcode

fun distributeCandies(candies: Int, numOfPeople: Int): IntArray {
    val res = IntArray(numOfPeople)
    var i = 0
    var c = candies
    while (c > 0) {
        res[i % numOfPeople] += c.coerceAtMost(i + 1)
        c -= i + 1
        ++i
    }
    return res
}
