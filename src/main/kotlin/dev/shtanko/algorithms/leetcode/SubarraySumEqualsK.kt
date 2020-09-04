package dev.shtanko.algorithms.leetcode

interface SubarraySumStrategy {
    fun perform(nums: IntArray, k: Int): Int
}

class SubarraySumBruteForce : SubarraySumStrategy {
    override fun perform(nums: IntArray, k: Int): Int {
        var count = 0
        for (start in nums.indices) {
            for (end in start + 1..nums.size) {
                var sum = 0
                for (i in start until end) sum += nums[i]
                if (sum == k) count++
            }
        }
        return count
    }
}

class SubarraySumUsingCumulativeSum : SubarraySumStrategy {
    override fun perform(nums: IntArray, k: Int): Int {
        var count = 0
        val sum = IntArray(nums.size + 1)
        sum[0] = 0
        for (i in 1..nums.size) sum[i] = sum[i - 1] + nums[i - 1]
        for (start in nums.indices) {
            for (end in start + 1..nums.size) {
                if (sum[end] - sum[start] == k) count++
            }
        }
        return count
    }
}

class SubarraySumWithoutSpace : SubarraySumStrategy {
    override fun perform(nums: IntArray, k: Int): Int {
        var count = 0
        for (start in nums.indices) {
            var sum = 0
            for (end in start until nums.size) {
                sum += nums[end]
                if (sum == k) count++
            }
        }
        return count
    }
}

class SubarraySumUsingHashmap : SubarraySumStrategy {
    override fun perform(nums: IntArray, k: Int): Int {
        var count = 0
        var sum = 0
        val map: HashMap<Int, Int> = HashMap()
        map[0] = 1
        for (element in nums) {
            sum += element
            if (map.containsKey(sum - k)) count += map[sum - k]!!
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        return count
    }
}
