/*
 * Copyright 2022 Oleksii Shtanko
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

import java.util.Arrays
import java.util.TreeSet
import kotlin.math.min

/**
 * 1187. Make Array Strictly Increasing
 * @link https://leetcode.com/problems/make-array-strictly-increasing/
 */
interface MakeArrayStrictlyIncreasing {
    fun perform(arr1: IntArray, arr2: IntArray): Int
}

class MakeArrayStrictlyIncreasingDP : MakeArrayStrictlyIncreasing {
    override fun perform(arr1: IntArray, arr2: IntArray): Int {
        if (arr1.isEmpty()) return -1
        if (arr1.size == 1) return 0
        val ts = TreeSet<Int?>()
        for (element in arr2) ts.add(element)
        val dp = Array(arr1.size + 1) { IntArray(arr1.size + 1) }
        for (i in dp.indices) Arrays.fill(dp[i], Int.MAX_VALUE)
        dp[0][0] = Int.MIN_VALUE

        for (j in 1 until dp.size) {
            for (i in 0..j) {
                if (arr1[j - 1] > dp[i][j - 1]) {
                    dp[i][j] = arr1[j - 1]
                }
                if (i > 0 && ts.higher(dp[i - 1][j - 1]) != null) {
                    dp[i][j] = min(dp[i][j], ts.higher(dp[i - 1][j - 1])!!)
                }
                if (j == dp.size - 1 && dp[i][j] != Int.MAX_VALUE) return i
            }
        }
        return -1
    }
}
