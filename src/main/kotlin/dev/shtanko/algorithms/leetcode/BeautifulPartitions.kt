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

import dev.shtanko.algorithms.MOD
import kotlin.math.max

/**
 * 2478. Number of Beautiful Partitions
 * @see <a href="https://leetcode.com/problems/number-of-beautiful-partitions">Source</a>
 */
fun interface BeautifulPartitions {
    operator fun invoke(s: String, k: Int, minLength: Int): Int
}

class BeautifulPartitionsDP : BeautifulPartitions {
    override operator fun invoke(s: String, k: Int, minLength: Int): Int {
        val cs: CharArray = s.toCharArray()
        val n = cs.size
        // make sure the input is valid
        if (!prime(cs[0]) || prime(cs[n - 1])) return 0
        val dp = Array(k) { IntArray(n) }
        // base case. If k = 1, the only thing required is to check if a character is prime
        var i: Int = n - minLength
        while (0 <= i) {
            dp[0][i] = if (prime(cs[i])) 1 else 0
            --i
        }
        for (i1 in 1 until k) {
            // re-use dp[k - 1][] and compute the `prefix sum` backwards
            // sum is the number of valid end points
            run {
                var j: Int = n - i1 * minLength
                var sum = 0
                while (0 <= j) {
                    // if dp[][] is 0, store the sum. othewise, it could be a possible valid end point.
                    if (0 == dp[i1 - 1][j]) {
                        dp[i1 - 1][j] = sum
                    } else if (0 != j && 0 == dp[i1 - 1][j - 1]) {
                        sum = (sum + dp[i1 - 1][j]) % MOD
                    }
                    --j
                }
            }
            // use 2 pointers [j, p] to find a valid substring
            var j = 0
            var p: Int = minLength - 1
            while (j + minLength * i1 < n) {
                if (!prime(cs[j])) {
                    ++j
                    continue
                }
                p = max(p, j + minLength - 1)
                while (prime(cs[p])) p++ // boundary check is skipped as the last character is not prime
                if (0 == dp[i1 - 1][p]) break // early break because there's no valid end points
                dp[i1][j] = dp[i1 - 1][p]
                ++j
            }
        }
        return dp[k - 1][0]
    }

    private fun prime(c: Char): Boolean {
        return '2' == c || '3' == c || '5' == c || '7' == c
    }
}
