package dev.shtanko.algorithms.leetcode

interface TwoSumStrategy {
    fun perform(nums: IntArray, target: Int): IntArray
}

class TwoSumBruteForce : TwoSumStrategy {
    override fun perform(nums: IntArray, target: Int): IntArray {
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if (nums[j] == target - nums[i]) {
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf()
        // or throw IllegalArgumentException("No two sum solution")
    }
}

class TwoSumTwoPassHashTable : TwoSumStrategy {
    override fun perform(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            map[nums[i]] = i
        }
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement) && map[complement] != i) {
                return intArrayOf(i, map[complement]!!)
            }
        }
        return intArrayOf()
        // or throw IllegalArgumentException("No two sum solution")
    }
}

class TwoSumOnePassHashTable : TwoSumStrategy {
    override fun perform(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = HashMap()
        for (i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
        // or throw IllegalArgumentException("No two sum solution")
    }
}
