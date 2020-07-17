package dev.shtanko.algorithms.leetcode

interface AbstractNumIdenticalPairs {
    fun perform(arr: IntArray): Int
}

class NumIdenticalPairsNaive : AbstractNumIdenticalPairs {
    override fun perform(arr: IntArray): Int {
        var count = 0
        for (i in 0 until arr.size - 1) {
            var j = i + 1
            while (j < arr.size) {
                if (arr[i] == arr[j]) {
                    count++
                }
                j++
            }
        }
        return count
    }
}

class NumIdenticalPairsMap : AbstractNumIdenticalPairs {
    override fun perform(arr: IntArray): Int {
        val map: MutableMap<Int, Int> = HashMap()
        var count = 0
        for (num in arr) {
            count += map.getOrDefault(num, 0)
            map[num] = map.getOrDefault(num, 0) + 1
        }
        return count
    }
}

class NumIdenticalPairsSort : AbstractNumIdenticalPairs {
    override fun perform(arr: IntArray): Int {
        arr.sort()
        var count = 0
        var i = 0
        for (j in 1 until arr.size) {
            if (arr[j] == arr[i]) {
                count += j - i
            } else {
                i = j
            }
        }
        return count
    }
}
