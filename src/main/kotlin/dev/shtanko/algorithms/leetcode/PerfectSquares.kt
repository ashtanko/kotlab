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

import dev.shtanko.algorithms.math.sqrt
import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

/**
 * 279. Perfect Squares
 * @see <a href="https://leetcode.com/problems/perfect-squares/">Source</a>
 */
fun interface PerfectSquares {
    fun numSquares(n: Int): Int
}

/**
 * Dynamic Programming
 */
class PerfectSquaresDP : PerfectSquares {
    override fun numSquares(n: Int): Int {
        val list: MutableList<Int> = ArrayList()
        var temp = 1
        while (temp * temp <= n) {
            val square = temp * temp
            if (n == square) {
                return 1
            }
            list.add(square)
            temp += 1
        }

        val dp = IntArray(n + 1)
        dp[0] = 0
        for (i in 1 until dp.size) {
            dp[i] = Int.MAX_VALUE
            for (j in 0 until list.size) {
                if (i - list[j] >= 0 && dp[i - list[j]] != Int.MAX_VALUE && dp[i] > dp[i - list[j]] + 1) {
                    dp[i] = dp[i - list[j]] + 1
                }
            }
        }

        return if (dp[n] == Int.MAX_VALUE) -1 else dp[n]
    }
}

/**
 * Static Dynamic Programming
 */
class PerfectSquaresStaticDP : PerfectSquares {
    override fun numSquares(n: Int): Int {
        val result: MutableList<Int> = ArrayList()
        if (result.isEmpty()) {
            result.add(0)
        }
        while (result.size <= n) {
            val m: Int = result.size
            var tempMin = Int.MAX_VALUE
            var j = 1
            while (j * j <= m) {
                tempMin = min(tempMin, result[m - j * j] + 1)
                j++
            }
            result.add(tempMin)
        }
        return result[n]
    }
}

/**
 * Mathematical Solution
 */
class PerfectSquaresMath : PerfectSquares {
    override fun numSquares(n: Int): Int {
        var n1 = n
        if (isSquare(n1)) return 1

        // The result is 4 if and only if n can be written in the
        // form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while (n1 and 3 == 0) { // n%4 == 0
            n1 = n1 shr 2
        }
        if (n1 and 7 == 7) { // n%8 == 7
            return 4
        }

        // Check whether 2 is the result.
        val sqrtN = sqrt(n1).toInt()
        for (i in 1..sqrtN) {
            if (isSquare(n1 - i * i)) {
                return 2
            }
        }

        return 3
    }

    private fun isSquare(n: Int): Boolean {
        val sqrtN = sqrt(n)
        return sqrtN * sqrtN == n.toDouble()
    }
}

/**
 * Breadth-First Search
 */
class PerfectSquaresBFS : PerfectSquares {
    override fun numSquares(n: Int): Int {
        val q: Queue<Int> = LinkedList()
        val visited: MutableSet<Int> = HashSet()
        q.offer(0)
        visited.add(0)
        var depth = 0
        while (q.isNotEmpty()) {
            var size: Int = q.size
            depth++
            while (size-- > 0) {
                val u: Int = q.poll()
                var i = 1
                while (i * i <= n) {
                    val v = u + i * i
                    if (v == n) {
                        return depth
                    }
                    if (v > n) {
                        break
                    }
                    if (!visited.contains(v)) {
                        q.offer(v)
                        visited.add(v)
                    }
                    i++
                }
            }
        }
        return depth
    }
}
