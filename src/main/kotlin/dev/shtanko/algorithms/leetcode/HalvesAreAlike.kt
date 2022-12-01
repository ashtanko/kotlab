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

private const val VOWELS = "aeiouAEIOU"

/**
 * Determine if String Halves Are Alike
 * @link https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */
fun interface HalvesAreAlike {
    fun perform(s: String): Boolean
}

class HalvesAreAlikeBruteForce : HalvesAreAlike {
    override fun perform(s: String): Boolean {
        val n = s.length
        val mid = n / 2
        val a = s.substring(0, mid)
        val b = s.substring(mid, n)
        var leftCount = 0
        var rightCount = 0
        for (c in a) {
            if (VOWELS.contains(c)) leftCount++
        }
        for (c in b) {
            if (VOWELS.contains(c)) rightCount++
        }
        return leftCount == rightCount
    }
}

class HalvesAreAlikeCount : HalvesAreAlike {
    override fun perform(s: String): Boolean {
        val n = s.length
        val mid = n / 2
        return countVowel(0 until mid, s) == countVowel(mid until n, s)
    }

    private fun countVowel(range: IntRange, s: String): Int {
        var count = 0
        for (i in range) {
            if (VOWELS.indexOf(s[i]) != -1) {
                count++
            }
        }
        return count
    }
}
