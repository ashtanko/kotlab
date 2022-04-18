/*
 * Copyright 2021 Oleksii Shtanko
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

import dev.shtanko.algorithms.extensions.isPalindrome

enum class SPNumType(val value: Int) {
    EVEN(1),
    ODD(2)
}

/**
 * 906. Super Palindromes
 * @link https://leetcode.com/problems/super-palindromes/
 */
object SuperPalindromes {
    private const val MAGIC = 100_000

    fun superPalindromesInRange(left: String, right: String): Int {
        val l = left.toLong()
        val r = right.toLong()
        var ans = 0
        countLen(l, r, SPNumType.ODD) {
            ans++
        }
        countLen(l, r, SPNumType.EVEN) {
            ans++
        }
        return ans
    }

    private fun countLen(l: Long, r: Long, numType: SPNumType, increase: () -> Unit) {
        for (k in 1 until MAGIC) {
            val sb = StringBuilder(k.toString())
            for (i in sb.length - numType.value downTo 0) {
                sb.append(sb[i])
            }
            var v = sb.toString().toLong()
            v *= v
            if (v > r) break
            if (v >= l && v.isPalindrome()) increase()
        }
    }
}
