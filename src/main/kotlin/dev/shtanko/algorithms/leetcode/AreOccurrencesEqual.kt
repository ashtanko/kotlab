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

import java.util.Arrays

/**
 * 1941. Check if All Characters Have Equal Number of Occurrences
 * link https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
 */
interface AreOccurrencesEqual {
    fun perform(s: String): Boolean
}

class AreOccurrencesEqualKotlin : AreOccurrencesEqual {
    override fun perform(s: String): Boolean {
        val num = s.count { it == s[0] }
        for (i in 1 until s.length) {
            if (num != s.count { it == s[i] }) return false
        }
        return true
    }
}

class AreOccurrencesEqualBF : AreOccurrencesEqual {
    override fun perform(s: String): Boolean {
        val fr = IntArray(ARR_SIZE)
        s.chars().forEach { c -> fr[c - 'a'.code]++ }
        return Arrays.stream(fr).filter { f -> f > 0 }.allMatch { f -> f == Arrays.stream(fr).max().asInt }
    }

    companion object {
        private const val ARR_SIZE = 26
    }
}
