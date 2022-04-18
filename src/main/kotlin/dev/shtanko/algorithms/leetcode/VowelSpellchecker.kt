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

interface VowelSpellchecker {
    fun perform(wordlist: Array<String>, queries: Array<String>): Array<String>
}

class VowelSpellcheckerImpl : VowelSpellchecker {

    private val wordsPerfect: MutableSet<String> = HashSet()
    private val wordsCap: MutableMap<String, String> = HashMap()
    private val wordsVow: MutableMap<String, String> = HashMap()

    override fun perform(wordlist: Array<String>, queries: Array<String>): Array<String> {
        for (word in wordlist) {
            wordsPerfect.add(word)
            val wordlow = word.lowercase()
            wordsCap.putIfAbsent(wordlow, word)
            val wordlowDV = devowel(wordlow)
            wordsVow.putIfAbsent(wordlowDV, word)
        }

        val ans = Array(queries.size) { "" }
        var t = 0
        for (query in queries) ans[t++] = solve(query) ?: ""
        return ans
    }

    private fun solve(query: String): String? {
        if (wordsPerfect.contains(query)) return query
        val queryL = query.lowercase()
        if (wordsCap.containsKey(queryL)) return wordsCap[queryL]
        val queryLV = devowel(queryL)
        return if (wordsVow.containsKey(queryLV)) wordsVow[queryLV] else ""
    }

    private fun devowel(word: String): String {
        val ans = StringBuilder()
        for (c in word.toCharArray()) ans.append(if (isVowel(c)) '*' else c)
        return ans.toString()
    }

    private fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
    }
}
