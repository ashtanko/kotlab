package dev.shtanko.algorithms.leetcode

fun IntArray.twoSum(target: Int): IntArray {
    val map = hashMapOf<Int, Int>()
    for (i in this.indices) {
        if (map.containsKey(target - this[i])) {
            val tmp = map[target - this[i]] ?: return intArrayOf()
            return intArrayOf(tmp, i)
        }
        map[this[i]] = i
    }
    return intArrayOf()
}
