package dev.shtanko.algorithms.leetcode

fun IntArray.kidsWithCandiesStream(extraCandies: Int): BooleanArray {
    return map {
        it + extraCandies >= max()!!
    }.toBooleanArray()
}

fun IntArray.kidsWithCandies(extraCandies: Int): BooleanArray {
    val arr = BooleanArray(size) { true }

    for (i in indices) {
        if (this[i] + extraCandies < max()!!) {
            arr[i] = false
        }
    }
    return arr
}
