package dev.shtanko.algorithms.leetcode

interface FindMaxAverageStrategy {
    fun perform(nums: IntArray, k: Int): Double
}

class FindMaxAverage1 : FindMaxAverageStrategy {
    override fun perform(nums: IntArray, k: Int): Double {
        val sum = IntArray(nums.size)
        sum[0] = nums[0]
        for (i in 1 until nums.size) sum[i] = sum[i - 1] + nums[i]
        var res = sum[k - 1] * 1.0 / k
        for (i in k until nums.size) {
            res = res.coerceAtLeast((sum[i] - sum[i - k]) * 1.0 / k)
        }
        return res
    }
}

class FindMaxAverage2 : FindMaxAverageStrategy {
    override fun perform(nums: IntArray, k: Int): Double {
        var sum = 0.0
        for (i in 0 until k) sum += nums[i]
        var res = sum
        for (i in k until nums.size) {
            sum += nums[i] - nums[i - k].toDouble()
            res = res.coerceAtLeast(sum)
        }
        return res / k
    }
}
