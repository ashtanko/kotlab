/*
 * Copyright 2020 Alexey Shtanko
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

import java.util.ArrayList
import kotlin.math.max

/**
 * Word Abbreviation.
 * @link https://leetcode.com/problems/word-abbreviation/
 */
interface WordAbbreviation {
    fun perform(dict: List<String>): List<String>

    fun abbrev(word: String, i: Int): String {
        val n = word.length
        return if (n - i <= 3) word else word.substring(0, i + 1) + (n - i - 2) + word[n - 1]
    }
}

/**
 * Approach #1: Greedy.
 */
class WordAbbreviationGreedy : WordAbbreviation {
    override fun perform(dict: List<String>): List<String> {
        val n: Int = dict.size
        val ans = Array(n) { "" }
        val prefix = IntArray(n)

        for (i in 0 until n) ans[i] = abbrev(dict[i], 0)

        for (i in 0 until n) {
            while (true) {
                val dupes: MutableSet<Int> = HashSet()
                for (j in i + 1 until n) if (ans[i] == ans[j]) dupes.add(j)
                if (dupes.isEmpty()) break
                dupes.add(i)
                for (k in dupes) ans[k] = abbrev(dict[k], ++prefix[k])
            }
        }

        return ans.toList()
    }
}

class IndexedWord(var word: String, var index: Int)

internal class WordTrieNode {
    var children: Array<WordTrieNode?> = arrayOfNulls(26)
    var count: Int = 0
}

/**
 * Approach #2: Group + Least Common Prefix.
 */
class WordAbbreviationLCP : WordAbbreviation {
    override fun perform(dict: List<String>): List<String> {
        val groups: MutableMap<String, MutableList<IndexedWord>> = HashMap()
        val ans = Array(dict.size) { "" }

        for ((index, word) in dict.withIndex()) {
            val ab = abbrev(word, 0)
            if (!groups.containsKey(ab)) groups[ab] = ArrayList()
            groups[ab]?.add(IndexedWord(word, index))
        }

        for (group in groups.values) {
            group.sortWith { a: IndexedWord, b: IndexedWord ->
                a.word.compareTo(b.word)
            }

            val lcp = IntArray(group.size)
            for (i in 1 until group.size) {
                val p = longestCommonPrefix(group[i - 1].word, group[i].word)
                lcp[i] = p
                lcp[i - 1] = max(lcp[i - 1], p)
            }
            for (i in group.indices) ans[group[i].index] = abbrev(group[i].word, lcp[i])
        }

        return ans.toList()
    }

    private fun longestCommonPrefix(word1: String, word2: String): Int {
        var i = 0
        while (i < word1.length && i < word2.length && word1[i] == word2[i]) i++
        return i
    }
}

/**
 * Approach #3: Group + Trie.
 */
class WordAbbreviationTrie : WordAbbreviation {
    override fun perform(dict: List<String>): List<String> {
        val groups: MutableMap<String, MutableList<IndexedWord?>> = HashMap()
        val ans = Array(dict.size) { "" }

        for ((index, word) in dict.withIndex()) {
            val ab = abbrev(word, 0)
            if (!groups.containsKey(ab)) groups[ab] = ArrayList()
            groups[ab]!!.add(IndexedWord(word, index))
        }

        for (group in groups.values) {
            val trie = WordTrieNode()
            for (iw in group) {
                var cur = trie
                for (letter in iw!!.word.substring(1).toCharArray()) {
                    if (cur.children[letter - 'a'] == null) cur.children[letter - 'a'] = WordTrieNode()
                    cur.count++
                    cur = cur.children[letter - 'a']!!
                }
            }
            for (iw in group) {
                var cur = trie
                var i = 1
                for (letter in iw!!.word.substring(1).toCharArray()) {
                    if (cur.count == 1) break
                    cur = cur.children[letter - 'a']!!
                    i++
                }
                ans[iw.index] = abbrev(iw.word, i - 1)
            }
        }
        return ans.toList()
    }
}
