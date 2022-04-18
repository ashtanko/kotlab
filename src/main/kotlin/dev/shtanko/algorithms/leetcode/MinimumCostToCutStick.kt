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

import java.util.ArrayList
import kotlin.math.min

class MinimumCostToCutStick {

    fun perform(n: Int, cuts: IntArray): Int {
        val c = ArrayList<Int>()
        for (cut in cuts) c.add(cut)
        c.addAll(listOf(0, n))
        c.sort()
        val dp = Array(c.size) { IntArray(c.size) }
        for (i in c.indices.reversed()) for (j in i + 1 until c.size) {
            for (k in i + 1 until j) dp[i][j] = min(
                if (dp[i][j] == 0) Int.MAX_VALUE else dp[i][j],
                c[j] - c[i] + dp[i][k] + dp[k][j]
            )
        }
        return dp[0][c.size - 1]
    }
}
