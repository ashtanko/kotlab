/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import kotlin.experimental.and
import kotlin.experimental.or

/**
 * Given an array of integers, find if the array contains any duplicates.
 * @link https://leetcode.com/problems/contains-duplicate/
 */
interface ContainsDuplicateStrategy {
    fun perform(arr: IntArray): Boolean
}

/**
 * Approach #1 (Naive Linear Search) [Time Limit Exceeded]
 * Time complexity: O(n^2).
 * Space complexity: O(1).
 */
class IsContainsDuplicateBrutForce : ContainsDuplicateStrategy {
    override fun perform(arr: IntArray): Boolean {
        for (i in arr.indices) {
            for (j in i + 1 until arr.size) {
                if (arr[i] == arr[j]) return true
            }
        }
        return false
    }
}

/**
 * Time complexity: O(n log n).
 * Space complexity: O(1) - not counting the memory used by sort
 */
class IsContainsDuplicateSort : ContainsDuplicateStrategy {
    override fun perform(arr: IntArray): Boolean {
        arr.sort()
        for (i in 0 until arr.size - 1) {
            if (arr[i] == arr[i + 1]) return true
        }
        return false
    }
}

/**
 * Time complexity: O(n).
 * Space complexity: O(n).
 */
class IsContainsDuplicateSortSetSize : ContainsDuplicateStrategy {
    override fun perform(arr: IntArray): Boolean {
        return arr.toHashSet().size < arr.size
    }
}

/**
 * Time complexity: O(n).
 * Space complexity: O(n).
 */
class IsContainsDuplicateSortSet : ContainsDuplicateStrategy {
    override fun perform(arr: IntArray): Boolean {
        val set = hashSetOf<Int>()

        for (i in arr.indices) {
            if (set.contains(arr[i])) return true
            set.add(arr[i])
        }

        return false
    }
}

class IsContainsDuplicateSortSetOptimized : ContainsDuplicateStrategy {
    override fun perform(arr: IntArray): Boolean {
        val set = hashSetOf<Int>()

        for (i in arr.indices) {
            if (!set.add(arr[i])) return true
        }
        return false
    }
}

class IsContainsDuplicateBitManipulation : ContainsDuplicateStrategy {

    override fun perform(arr: IntArray): Boolean {
        val mark = ByteArray(ARR_SIZE)
        for (i in arr) {
            val j = i / OCTAL
            val k = i % OCTAL
            val check = 1 shl k
            if (mark[j] and check.toByte() != 0.toByte()) {
                return true
            }
            mark[j] = mark[j] or check.toByte()
        }
        return false
    }

    companion object {
        private const val ARR_SIZE = 150000
    }
}
