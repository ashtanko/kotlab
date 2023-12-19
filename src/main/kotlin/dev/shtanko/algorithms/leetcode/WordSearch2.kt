/*
 * Copyright 2022 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.ALPHABET_LETTERS_COUNT

/**
 * 212. Word Search II
 * @see <a href="https://leetcode.com/problems/word-search-ii/">Source</a>
 */
fun interface WordSearch2 {
    operator fun invoke(board: Array<CharArray>, words: Array<String>): List<String>
}

/**
 * Backtracking + Trie
 */
class WordSearch2Trie : WordSearch2 {
    override fun invoke(board: Array<CharArray>, words: Array<String>): List<String> {
        val res: MutableList<String> = ArrayList()
        val root: TrieNode = buildTrie(words)
        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                dfs(board, i, j, root, res)
            }
        }
        return res
    }

    fun dfs(board: Array<CharArray>, i: Int, j: Int, p: TrieNode, res: MutableList<String>) {
        var p0 = p
        val c = board[i][j]
        if (c == '#' || p0.next[c.code - 'a'.code] == null) return
        p0 = p0.next[c.code - 'a'.code]!!
        if (p0.word != null) {
            res.add(p0.word!!)
            p0.word = null
        }
        board[i][j] = '#'
        if (i > 0) dfs(board, i - 1, j, p0, res)
        if (j > 0) dfs(board, i, j - 1, p0, res)
        if (i < board.size - 1) dfs(board, i + 1, j, p0, res)
        if (j < board[0].size - 1) dfs(board, i, j + 1, p0, res)
        board[i][j] = c
    }

    private fun buildTrie(words: Array<String>): TrieNode {
        val root = TrieNode()
        for (w in words) {
            var p: TrieNode? = root
            for (c in w.toCharArray()) {
                val i = c.code - 'a'.code
                if (p?.next?.get(i) == null) p?.next?.set(i, TrieNode())
                p = p?.next?.get(i)
            }
            p?.word = w
        }
        return root
    }

    class TrieNode {
        var next = arrayOfNulls<TrieNode>(ALPHABET_LETTERS_COUNT)
        var word: String? = null
    }
}
