/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

/**
 * Given two arrays, write a function to compute their intersection.
 */
fun interface IntersectionStrategy {
    operator fun invoke(p: Pair<IntArray, IntArray>): IntArray
}

/**
 * Use two hash sets
 * Time complexity: O(n)
 */
class IntersectionTwoSets : IntersectionStrategy {
    override operator fun invoke(p: Pair<IntArray, IntArray>): IntArray {
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
    override operator fun invoke(p: Pair<IntArray, IntArray>): IntArray {
        val set: MutableSet<Int> = HashSet()
        p.first.sort()
        p.second.sort()
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
    override operator fun invoke(p: Pair<IntArray, IntArray>): IntArray {
        val set: MutableSet<Int> = HashSet()
        p.second.sort()
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
