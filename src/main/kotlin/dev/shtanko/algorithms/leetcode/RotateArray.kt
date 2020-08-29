package dev.shtanko.algorithms.leetcode

interface AbstractRotateArrayStrategy {
    fun perform(nums: IntArray, k: Int)
}

class RotateArrayBruteForce : AbstractRotateArrayStrategy {
    override fun perform(nums: IntArray, k: Int) {
        var a = k
        a %= nums.size
        var temp: Int
        var previous: Int
        for (i in 0 until a) {
            previous = nums[nums.size - 1]
            for (j in nums.indices) {
                temp = nums[j]
                nums[j] = previous
                previous = temp
            }
        }
    }
}

class RotateArrayUsingExtraArray : AbstractRotateArrayStrategy {
    override fun perform(nums: IntArray, k: Int) {
        val a = IntArray(nums.size)
        for (i in nums.indices) {
            a[(i + k) % nums.size] = nums[i]
        }
        for (i in nums.indices) {
            nums[i] = a[i]
        }
    }
}

class RotateArrayUsingCyclicReplacements : AbstractRotateArrayStrategy {
    override fun perform(nums: IntArray, k: Int) {
        val a: Int = k % nums.size
        var count = 0
        var start = 0
        while (count < nums.size) {
            var current = start
            var prev = nums[start]
            do {
                val next = (current + a) % nums.size
                val temp = nums[next]
                nums[next] = prev
                prev = temp
                current = next
                count++
            } while (start != current)
            start++
        }
    }
}

class RotateArrayUsingReverse : AbstractRotateArrayStrategy {
    override fun perform(nums: IntArray, k: Int) {
        var a = k
        a %= nums.size
        reverse(nums, 0, nums.size - 1)
        reverse(nums, 0, a - 1)
        reverse(nums, a, nums.size - 1)
    }

    private fun reverse(nums: IntArray, s: Int, e: Int) {
        var start = s
        var end = e
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start++
            end--
        }
    }
}
