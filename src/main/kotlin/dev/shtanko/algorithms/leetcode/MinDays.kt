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

import kotlin.math.min

/**
 * 1553. Minimum Number of Days to Eat N Oranges
 * @see <a href="https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/">leetcode page</a>
 */
sealed interface MinDays {
    operator fun invoke(n: Int): Int
}

class MinDaysSimple : MinDays {
    private var dp: MutableMap<Int, Int> = HashMap()

    override operator fun invoke(n: Int): Int {
        if (n <= 1) {
            return n
        }
        if (!dp.containsKey(n)) {
            dp[n] = 1 + min(n % 2 + invoke(n / 2), n % 3 + invoke(n / 3))
        }
        return dp.getOrDefault(n, n)
    }
}

class MinDaysDP : MinDays {
    private var dp = mutableMapOf(0 to 0, 1 to 1, 2 to 2)

    override operator fun invoke(n: Int): Int {
        return solve(n)
    }

    private fun solve(n: Int): Int {
        if (dp.containsKey(n)) {
            return dp.getOrDefault(n, -1)
        }
        var ans = Int.MAX_VALUE
        if (n % 2 == 0 && n % 3 == 0) {
            ans = min(ans, 1 + min(solve(n / 2), solve(n / 3)))
        } else if (n % 3 == 0) {
            ans = min(ans, 1 + min(solve(n - 1), solve(n / 3)))
        } else if (n % 2 == 0) {
            ans = if ((n - 1) % 3 == 0) {
                min(ans, 1 + min(solve(n / 2), solve(n - 1)))
            } else {
                min(ans, min(1 + solve(n / 2), 2 + solve(n - 2)))
            }
        } else {
            ans = min(ans, 1 + solve(n - 1))
            if ((n - 2) % 3 == 0) {
                ans = min(ans, 2 + solve(n - 2))
            }
        }
        dp[n] = ans
        return dp.getOrDefault(n, n)
    }
}
