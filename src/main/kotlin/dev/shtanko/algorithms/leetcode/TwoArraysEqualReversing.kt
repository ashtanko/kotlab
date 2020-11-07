package dev.shtanko.algorithms.leetcode

import java.util.HashMap

interface CanBeEqualStrategy {
    fun perform(target: IntArray, arr: IntArray): Boolean
}

class CanBeEqualSort : CanBeEqualStrategy {
    override fun perform(target: IntArray, arr: IntArray): Boolean {
        target.sort()
        arr.sort()
        return target.contentEquals(arr)
    }
}

class CanBeEqualMap : CanBeEqualStrategy {
    override fun perform(target: IntArray, arr: IntArray): Boolean {
        val n = arr.size
        val map = HashMap<Int, Int?>()
        for (i in 0 until n) {
            if (!map.containsKey(arr[i])) map[arr[i]] = 1 else map[arr[i]] = map[arr[i]]!! + 1
        }
        for (i in 0 until n) {
            if (!map.containsKey(target[i])) return false
            var count = map[target[i]]!!
            count--
            if (count == 0) map.remove(target[i]) else map[target[i]] = count
        }
        return true
    }
}
