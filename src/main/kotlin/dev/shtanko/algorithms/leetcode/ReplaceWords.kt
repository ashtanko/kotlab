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
 * 648. Replace Words
 * @link https://leetcode.com/problems/replace-words/
 */
interface ReplaceWords {
    fun perform(dictionary: List<String>, sentence: String): String
}

class PrefixHash : ReplaceWords {
    override fun perform(dictionary: List<String>, sentence: String): String {
        val rootSet: MutableSet<String> = HashSet(dictionary)

        val ans = StringBuilder()
        for (word in sentence.split("\\s+".toRegex())) {
            var prefix = ""
            for (i in 1..word.length) {
                prefix = word.substring(0, i)
                if (rootSet.contains(prefix)) break
            }
            if (ans.isNotEmpty()) ans.append(" ")
            ans.append(prefix)
        }
        return ans.toString()
    }
}

class ReplaceWordsTrie : ReplaceWords {
    override fun perform(dictionary: List<String>, sentence: String): String {
        val trie = TrieNode()
        for (root in dictionary) {
            var cur = trie
            for (letter in root.toCharArray()) {
                if (cur.children[letter.code - 'a'.code] == null) {
                    cur.children[letter.code - 'a'.code] = TrieNode()
                }
                cur = cur.children[letter.code - 'a'.code] ?: TrieNode()
            }
            cur.word = root
        }

        val ans = StringBuilder()

        for (word in sentence.split("\\s+".toRegex())) {
            if (ans.isNotEmpty()) ans.append(" ")
            var cur = trie
            for (letter in word.toCharArray()) {
                if (cur.children[letter.code - 'a'.code] == null || cur.word != null) break
                cur = cur.children[letter.code - 'a'.code] ?: TrieNode()
            }
            ans.append(if (cur.word != null) cur.word else word)
        }
        return ans.toString()
    }

    private class TrieNode {
        var children: Array<TrieNode?> = arrayOfNulls(ALPHABET_LETTERS_COUNT)
        var word: String? = null
    }
}
