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

/**
 * Prefix and Suffix Search
 * @see <a href="https://leetcode.com/problems/prefix-and-suffix-search/">leetcode page</a>
 */
fun interface WordFilter {
    operator fun invoke(prefix: String, suffix: String): Int
}

/**
 * Approach #1: Trie + Set Intersection [Time Limit Exceeded]
 */
class WordFilterTrie(words: Array<String>) : WordFilter {

    private var trie1: WFTrieNode = WFTrieNode()
    private var trie2: WFTrieNode = WFTrieNode()
    private var wt = 0

    init {
        for (word in words) {
            val ca = word.toCharArray()
            var cur: WFTrieNode = trie1
            cur.weight.add(wt)
            for (letter in ca) {
                if (cur.children[letter - 'a'] == null) {
                    cur.children[letter - 'a'] = WFTrieNode()
                }
                cur = cur.children[letter - 'a']!!
                cur.weight.add(wt)
            }
            cur = trie2
            cur.weight.add(wt)
            for (j in ca.indices.reversed()) {
                val letter = ca[j]
                if (cur.children[letter - 'a'] == null) {
                    cur.children[letter - 'a'] = WFTrieNode()
                }
                cur = cur.children[letter - 'a']!!
                cur.weight.add(wt)
            }
            wt++
        }
    }

    override operator fun invoke(prefix: String, suffix: String): Int {
        var cur1: WFTrieNode = trie1
        var cur2: WFTrieNode = trie2
        for (letter in prefix.toCharArray()) {
            if (cur1.children[letter - 'a'] == null) return -1
            cur1 = cur1.children[letter - 'a']!!
        }
        val ca = suffix.toCharArray()
        for (j in ca.indices.reversed()) {
            val letter = ca[j]
            if (cur2.children[letter - 'a'] == null) return -1
            cur2 = cur2.children[letter - 'a']!!
        }

        var ans = -1
        for (w1 in cur1.weight) if (w1 > ans && cur2.weight.contains(w1)) ans = w1

        return ans
    }

    class WFTrieNode {
        var children: Array<WFTrieNode?> = arrayOfNulls(ALPHABET_LETTERS_COUNT)
        var weight: MutableSet<Int> = HashSet()
    }
}

class WordFilterWrappedWords(words: Array<String>) : WordFilter {

    private var trie: TrieNode = TrieNode()

    init {
        for (weight in words.indices) {
            val word: String = words[weight] + "{"
            for (i in word.indices) {
                var cur: TrieNode = trie
                cur.weight = weight
                for (j in i until 2 * word.length - 1) {
                    val k = word[j % word.length] - 'a'
                    if (cur.children[k] == null) {
                        cur.children[k] = TrieNode()
                    }
                    cur = cur.children[k]!!
                    cur.weight = weight
                }
            }
        }
    }

    override operator fun invoke(prefix: String, suffix: String): Int {
        var cur: TrieNode = trie
        for (letter in "$suffix{$prefix".toCharArray()) {
            if (cur.children[letter - 'a'] == null) return -1
            cur = cur.children[letter - 'a']!!
        }
        return cur.weight
    }

    class TrieNode {
        var children: Array<TrieNode?> = arrayOfNulls(27)
        var weight: Int = 0
    }
}
