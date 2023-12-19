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

import dev.shtanko.algorithms.MOD

/**
 * Sum of Subsequence Widths.
 * @see <a href="https://leetcode.com/problems/sum-of-subsequence-widths/">Source</a>
 */
object SumSubseqWidths {

    operator fun invoke(a: IntArray): Int {
        val n: Int = a.size
        a.sort()

        val pow2 = LongArray(n)
        pow2[0] = 1
        for (i in 1 until n) pow2[i] = pow2[i - 1] * 2 % MOD

        var ans: Long = 0
        for (i in 0 until n) ans = (ans + (pow2[i] - pow2[n - 1 - i]) * a[i]) % MOD

        return ans.toInt()
    }
}
