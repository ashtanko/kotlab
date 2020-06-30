package dev.shtanko.algorithms.leetcode

import java.util.Arrays
import java.util.HashSet

/**
 * Given two arrays, write a function to compute their intersection.
 */
interface IntersectionStrategy {
    fun perform(p: Pair<IntArray, IntArray>): IntArray
}

/**
 * Use two hash sets
 * Time complexity: O(n)
 */
class IntersectionTwoSets : IntersectionStrategy {
    override fun perform(p: Pair<IntArray, IntArray>): IntArray {
        val set = p.first.toSet()
        val intersect: MutableSet<Int> = HashSet()

        for (num in p.second) {
            if (set.contains(num)) {
                intersect.add(num)
            }
        }
        val result = IntArray(intersect.size)
        var i = 0
        for (num in intersect) {
            result[i++] = num
        }

        return result
    }
}

/**
 * Sort both arrays, use two pointers
 * Time complexity: O(nlogn)
 */
class IntersectionTwoPointers : IntersectionStrategy {
    override fun perform(p: Pair<IntArray, IntArray>): IntArray {
        val set: MutableSet<Int> = HashSet()
        Arrays.sort(p.first)
        Arrays.sort(p.second)
        var i = 0
        var j = 0
        while (i < p.first.size && j < p.second.size) {
            when {
                p.first[i] < p.second[j] -> {
                    i++
                }
                p.first[i] > p.second[j] -> {
                    j++
                }
                else -> {
                    set.add(p.first[i])
                    i++
                    j++
                }
            }
        }
        val result = IntArray(set.size)
        var k = 0
        for (num in set) {
            result[k++] = num
        }
        return result
    }
}

/**
 *
 */
class IntersectionBinarySearch : IntersectionStrategy {
    override fun perform(p: Pair<IntArray, IntArray>): IntArray {
        val set: MutableSet<Int> = HashSet()
        Arrays.sort(p.second)
        for (num in p.first) {
            if (binarySearch(p.second, num)) {
                set.add(num)
            }
        }
        var i = 0
        val result = IntArray(set.size)
        for (num in set) {
            result[i++] = num
        }
        return result
    }

    private fun binarySearch(nums: IntArray, target: Int): Boolean {
        var low = 0
        var high = nums.size - 1
        while (low <= high) {
            val mid = low + (high - low) / 2
            if (nums[mid] == target) {
                return true
            }
            if (nums[mid] > target) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return false
    }
}
