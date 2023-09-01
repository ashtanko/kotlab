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
 * 1657. Determine if Two Strings Are Close
 * @see <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/">leetcode page</a>
 */
interface CloseStrings {
    operator fun invoke(word1: String, word2: String): Boolean
}

class CloseStringsMap : CloseStrings {

    override operator fun invoke(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) {
            return false
        }
        val wf = IntArray(ALPHABET_LETTERS_COUNT)
        val wf2 = IntArray(ALPHABET_LETTERS_COUNT)
        for (i in word1.indices) {
            wf[word1[i] - 'a'] += 1
            wf2[word2[i] - 'a'] += 1
        }
        for (i in 0 until ALPHABET_LETTERS_COUNT) {
            if (wf[i] == 0 && wf2[i] != 0) return false
        }
        val map: HashMap<Int, Int> = HashMap()
        for (i in 0 until ALPHABET_LETTERS_COUNT) {
            map[wf[i]] = map.getOrDefault(wf[i], 0) + 1
            map[wf2[i]] = map.getOrDefault(wf2[i], 0) - 1
        }
        for (key in map.keys) {
            if (map[key] != 0) {
                return false
            }
        }
        return true
    }
}

class CloseStringsBitwise : CloseStrings {

    override operator fun invoke(word1: String, word2: String): Boolean {
        if (word1.length != word2.length) return false

        val count1 = IntArray(ALPHABET_LETTERS_COUNT)
        val count2 = IntArray(ALPHABET_LETTERS_COUNT)
        for (ch in word1.toCharArray()) {
            ++count1[ch.code - 'a'.code]
        }
        for (ch in word2.toCharArray()) {
            ++count2[ch.code - 'a'.code]
        }

        var signature = 0
        for (i in 0 until ALPHABET_LETTERS_COUNT) {
            if (count1[i] > 0 && count2[i] == 0 || count2[i] > 0 && count1[i] == 0) {
                return false
            }
            signature = signature xor count1[i]
            signature = signature xor count2[i]
        }

        return signature == 0
    }
}

class CloseStringsSort : CloseStrings {
    override operator fun invoke(word1: String, word2: String): Boolean {
        val freq1 = IntArray(ALPHABET_LETTERS_COUNT)
        val freq2 = IntArray(ALPHABET_LETTERS_COUNT)
        for (element in word1) {
            freq1[element - 'a']++
        }
        for (element in word2) {
            freq2[element - 'a']++
        }
        for (i in 0 until ALPHABET_LETTERS_COUNT) {
            if (freq1[i] == 0 && freq2[i] != 0 || freq1[i] != 0 && freq2[i] == 0) {
                return false
            }
        }
        freq1.sort()
        freq2.sort()
        for (i in 0 until ALPHABET_LETTERS_COUNT) {
            if (freq1[i] != freq2[i]) {
                return false
            }
        }
        return true
    }
}
