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

/**
 * 2063. Vowels of All Substrings
 * @see <a href="https://leetcode.com/problems/vowels-of-all-substrings/">leetcode page</a>
 */
interface VowelsAllSubstrings {
    fun countVowels(word: String): Long
}

class VowelsAllSubstringsImpl : VowelsAllSubstrings {
    override fun countVowels(word: String): Long {
        var res: Long = 0
        val n: Long = word.length.toLong()
        for (i in 0 until n) {
            if (VOWELS.indexOf(word[i.toInt()]) >= 0) {
                res += (i + 1) * (n - i)
            }
        }
        return res
    }

    companion object {
        private const val VOWELS = "aeiou"
    }
}
