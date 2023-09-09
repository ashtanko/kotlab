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

fun interface ShortestPalindromeStrategy {
    operator fun invoke(s: String): String
}

class ShortestPalindromeBruteForce : ShortestPalindromeStrategy {
    override operator fun invoke(s: String): String {
        val n = s.length
        var len = 0
        for (k in n - 1 downTo 0) {
            var i = 0
            var j = k
            while (i < j) {
                if (s[i] != s[j]) break
                i++
                j--
            }
            if (i >= j) {
                len = k
                break
            }
        }
        val sb = java.lang.StringBuilder()
        for (i in n - 1 downTo len + 1) {
            sb.append(s[i])
        }
        sb.append(s)
        return sb.toString()
    }
}

class ShortestPalindromeTwoPointers : ShortestPalindromeStrategy {
    override operator fun invoke(s: String): String {
        var str = s
        var i = 0
        var j = str.length - 1
        while (i < j) {
            val ith = str[i]
            val jth = str[j]
            if (ith == jth) {
                i++
                j--
            } else {
                str = str.substring(0, i) + jth + str.substring(i)
                i++
            }
        }
        return str
    }
}

class ShortestPalindromeMP : ShortestPalindromeStrategy {
    override operator fun invoke(s: String): String {
        val temp = s + "#" + StringBuilder(s).reverse().toString()
        val table = getTable(temp)
        return StringBuilder(s.substring(table[table.size - 1])).reverse().toString() + s
    }

    private fun getTable(s: String): IntArray {
        // get lookup table
        val table = IntArray(s.length)

        // pointer that points to matched char in prefix part
        var index = 0
        // skip index 0, we will not match a string with itself
        for (i in 1 until s.length) {
            if (s[index] == s[i]) {
                // we can extend match in prefix and postfix
                table[i] = table[i - 1] + 1
                index++
            } else {
                // match failed, we try to match a shorter substring

                // by assigning index to table[i-1], we will shorten the match string length, and jump to the
                // prefix part that we used to match postfix ended at i - 1
                index = table[i - 1]
                while (index > 0 && s[index] != s[i]) {
                    // we will try to shorten the match string length until we revert to the beginning of
                    // match (index 1)
                    index = table[index - 1]
                }

                // when we are here may either found a match char or we reach the boundary and still no luck
                // so we need check char match
                if (s[index] == s[i]) {
                    // if match, then extend one char
                    index++
                }
                table[i] = index
            }
        }
        return table
    }
}
