package dev.shtanko.algorithms.leetcode

interface LargestUniqueNumber {
    fun perform(arr: IntArray): Int
}

/**
 * O(n) time.
 * O(1) space.
 */
class LargestUniqueNumberBruteForce : LargestUniqueNumber {

    companion object {
        private const val ARR_SIZE = 1001
    }

    override fun perform(arr: IntArray): Int {
        var res = -1
        val temp = IntArray(ARR_SIZE)
        for (i in arr.indices) {
            temp[arr[i]]++
        }
        for (i in temp.size - 1 downTo 0) {
            if (temp[i] == 1) {
                res = i
                break
            }
        }
        return res
    }
}

/**
 *
 */
class LargestUniqueNumberHashMap : LargestUniqueNumber {
    override fun perform(arr: IntArray): Int {
        val seen: MutableMap<Int, Int> = HashMap()
        for (i in arr.indices) {
            seen[arr[i]] = seen.getOrDefault(arr[i], 0) + 1
        }
        var result = -1
        for ((key, value) in seen) {
            if (value == 1 && key > result) {
                result = key
            }
        }
        return result
    }
}
