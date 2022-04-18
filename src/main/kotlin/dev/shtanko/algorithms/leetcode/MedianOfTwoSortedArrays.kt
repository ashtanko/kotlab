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

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 */
fun Pair<IntArray, IntArray>.findMedianSortedArrays(): Double {
    val m = first.size
    val n = second.size
    val l = m.plus(n).plus(1).div(2)
    val r = m.plus(n).plus(2).div(2)
    val local = findKth(first, 0, second, 0, l) + findKth(first, 0, second, 0, r)
    return local.div(2.0)
}

private fun findKth(nums1: IntArray, aStart: Int, nums2: IntArray, bStart: Int, k: Int): Double {
    if (aStart >= nums1.size) {
        return nums2[bStart + k - 1].toDouble()
    }
    if (bStart >= nums2.size) {
        return nums1[aStart + k - 1].toDouble()
    }

    if (k == 1) {
        return nums1[aStart].coerceAtMost(nums2[bStart]).toDouble()
    }

    val aMid = aStart + k / 2 - 1
    val bMid = bStart + k / 2 - 1

    val aVal = if (aMid >= nums1.size) Int.MAX_VALUE else nums1[aMid]
    val bVal = if (bMid >= nums2.size) Int.MAX_VALUE else nums2[bMid]

    return if (aVal <= bVal) {
        findKth(nums1, aMid + 1, nums2, bStart, k - k / 2)
    } else {
        findKth(nums1, aStart, nums2, bMid + 1, k - k / 2)
    }
}
