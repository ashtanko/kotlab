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
 * 1359. Count All Valid Pickup and Delivery Options
 * @see <a href="https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options">Source</a>
 */
fun interface CountOrders {
    operator fun invoke(n: Int): Int
}

class CountOrdersBottomUp : CountOrders {
    override fun invoke(n: Int): Int {
        var res: Long = 1
        for (i in 1..n) {
            res = res * (i * 2 - 1) * i % MOD
        }
        return res.toInt()
    }
}

class CountOrdersRecursion : CountOrders {
    override fun invoke(n: Int): Int {
        return if (n > 0) (invoke(n - 1).toLong() * (n * 2 - 1) * n % (MOD + 7)).toInt() else 1
    }
}

class CountOrdersFactorial : CountOrders {
    private val memo: MutableMap<Int, Long> = HashMap()

    override fun invoke(n: Int): Int {
        val factorial = factorial(n * 2)
        return (factorial.shr(n) % MOD).toInt()
    }

    private fun factorial(n: Int): Long {
        if (n <= 1) {
            return 1L // Base case: factorial of 0 and 1 is 1
        }

        if (memo.containsKey(n)) {
            return memo.getOrDefault(n, 1)
        }

        val result = n.toLong() * factorial(n - 1)
        memo[n] = result
        return result
    }
}
