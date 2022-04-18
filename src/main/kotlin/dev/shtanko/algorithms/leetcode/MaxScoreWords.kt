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
 * 1255. Maximum Score Words Formed by Letters
 * @link https://leetcode.com/problems/maximum-score-words-formed-by-letters/
 */
interface MaxScoreWords {
    fun perform(words: Array<String>, letters: CharArray, score: IntArray): Int
}

class MaxScoreWordsBacktracking : MaxScoreWords {
    override fun perform(words: Array<String>, letters: CharArray, score: IntArray): Int {
        if (words.isEmpty() || letters.isEmpty() || score.isEmpty()) return 0
        val count = IntArray(score.size)
        for (ch in letters) {
            count[ch.code - 'a'.code]++
        }
        return backtrack(words, count, score, 0)
    }

    private fun backtrack(words: Array<String>, count: IntArray, score: IntArray, index: Int): Int {
        var max = 0
        for (i in index until words.size) {
            var res = 0
            var isValid = true
            for (ch in words[i].toCharArray()) {
                count[ch.code - 'a'.code]--
                res += score[ch.code - 'a'.code]
                if (count[ch.code - 'a'.code] < 0) isValid = false
            }
            if (isValid) {
                res += backtrack(words, count, score, i + 1)
                max = max(res, max)
            }
            for (ch in words[i].toCharArray()) {
                count[ch.code - 'a'.code]++
            }
        }
        return max
    }
}

class MaxScoreWordsDFS : MaxScoreWords {
    override fun perform(words: Array<String>, letters: CharArray, score: IntArray): Int {
        val memo = IntArray(ARR_SIZE)
        for (l in letters) {
            memo[l.code - 'a'.code]++
        }
        return dfs(0, memo, score, words)
    }

    fun dfs(index: Int, memo: IntArray, score: IntArray, words: Array<String>): Int {
        if (index == words.size) {
            return 0
        }
        var res = 0
        val w = words[index]
        var count = 0
        var i = 0
        val temp: IntArray = memo.copyOf(memo.size)
        while (i < w.length) {
            val c = w[i]
            count += if (temp[c.code - 'a'.code] > 0) {
                temp[c.code - 'a'.code]--
                score[c.code - 'a'.code]
            } else {
                break
            }
            i++
        }
        if (i == w.length) {
            res = max(res, count + dfs(index + 1, temp, score, words))
        }
        res = max(dfs(index + 1, memo, score, words), res)
        return res
    }

    companion object {
        private const val ARR_SIZE = 26
    }
}
