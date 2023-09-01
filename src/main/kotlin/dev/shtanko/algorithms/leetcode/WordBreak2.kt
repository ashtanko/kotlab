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

import kotlin.math.max

/**
 * 140. Word Break II
 * @see <a href="https://leetcode.com/problems/word-break-ii/">leetcode page</a>
 */
interface WordBreak2 {
    operator fun invoke(s: String, wordDict: List<String>): List<String>
}

class WordBreak2DPDFS : WordBreak2 {
    override operator fun invoke(s: String, wordDict: List<String>): List<String> {
        val starts: Array<MutableList<Int>?> = arrayOfNulls(s.length + 1)

        starts[0] = ArrayList()

        val maxLen = getMaxLen(wordDict)
        for (i in 1..s.length) {
            var j = i - 1
            while (j >= i - maxLen && j >= 0) {
                if (starts[j] == null) {
                    j--
                    continue
                }
                val word = s.substring(j, i)
                if (wordDict.contains(word)) {
                    if (starts[i] == null) {
                        starts[i] = ArrayList()
                    }
                    starts[i]?.add(j)
                }
                j--
            }
        }

        val rst: MutableList<String> = ArrayList()
        if (starts[s.length] == null) {
            return rst
        }

        dfs(rst, "", s, starts, s.length)
        return rst
    }

    private fun dfs(rst: MutableList<String>, path: String, s: String, starts: Array<MutableList<Int>?>, end: Int) {
        if (end == 0) {
            rst.add(path.substring(1))
            return
        }
        for (start in starts[end] ?: emptyList()) {
            val word = s.substring(start, end)
            dfs(rst, " $word$path", s, starts, start)
        }
    }

    private fun getMaxLen(wordDict: List<String>): Int {
        var max = 0
        for (s in wordDict) {
            max = max(max, s.length)
        }
        return max
    }
}

/**
 * Method 3: DP Prunning + Backtracking
 */
class WordBreak2Backtracking : WordBreak2 {
    override operator fun invoke(s: String, wordDict: List<String>): List<String> {
        val rst: MutableList<String> = ArrayList()
        val canBreak = BooleanArray(s.length) { true }
        val sb = StringBuilder()
        dfs(rst, sb, s, wordDict, canBreak, 0)
        return rst
    }

    private fun dfs(
        rst: MutableList<String>,
        sb: StringBuilder,
        s: String,
        dict: List<String>,
        canBreak: BooleanArray,
        start: Int,
    ) {
        if (start == s.length) {
            rst.add(sb.substring(1))
            return
        }
        if (!canBreak[start]) {
            return
        }
        for (i in start + 1..s.length) {
            val word = s.substring(start, i)
            if (!dict.contains(word)) {
                continue
            }
            val sbBeforeAdd = sb.length
            sb.append(" $word")
            val rstBeforeDFS = rst.size
            dfs(rst, sb, s, dict, canBreak, i)
            if (rst.size == rstBeforeDFS) {
                canBreak[i] = false
            }
            sb.delete(sbBeforeAdd, sb.length)
        }
    }
}

class WordBreak2DFS : WordBreak2 {
    override operator fun invoke(s: String, wordDict: List<String>): List<String> {
        return backtrack(s, wordDict, HashMap())
    }

    // backtrack returns an array including all substrings derived from s.
    private fun backtrack(s: String, wordDict: List<String>, mem: MutableMap<String, List<String>>): List<String> {
        if (mem.containsKey(s)) return mem[s] ?: emptyList()
        val result: MutableList<String> = ArrayList()
        for (word in wordDict) if (s.startsWith(word)) {
            val next = s.substring(word.length)
            if (next.isEmpty()) {
                result.add(word)
            } else {
                for (sub in backtrack(next, wordDict, mem)) {
                    result.add(
                        "$word $sub",
                    )
                }
            }
        }
        mem[s] = result
        return result
    }
}
