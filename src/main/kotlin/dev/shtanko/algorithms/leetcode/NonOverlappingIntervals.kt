/*
 * Copyright 2023 Oleksii Shtanko
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
 * 435. Non-overlapping Intervals
 * @see <a href="https://leetcode.com/problems/non-overlapping-intervals/">leetcode page</a>
 */
interface NonOverlappingIntervals {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int
}

class NonOverlappingIntervalsGreedy : NonOverlappingIntervals {
    override fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortWith { a, b -> if (a[1] != b[1]) a[1] - b[1] else b[0] - a[0] }
        var v = intervals[0]
        var ans = -1
        intervals.forEach { if (it[0] < v[1]) ans++ else v = it }
        return ans
    }
}
