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
import kotlin.math.min

/**
 * 691. Stickers to Spell Word
 * @see <a href="https://leetcode.com/problems/stickers-to-spell-word/">leetcode page</a>
 */
fun interface StickersToSpellWord {
    fun minStickers(stickers: Array<String>, target: String): Int
}

/**
 * DP + Memoization with optimization
 */
class StickersToSpellWordDP : StickersToSpellWord {
    override fun minStickers(stickers: Array<String>, target: String): Int {
        val m: Int = stickers.size
        val mp = Array(m) { IntArray(ALPHABET_LETTERS_COUNT) }
        val dp: MutableMap<String, Int> = HashMap()
        for (i in 0 until m) for (c in stickers[i].toCharArray()) mp[i][c - 'a']++
        dp[""] = 0
        return helper(dp, mp, target)
    }

    private fun helper(dp: MutableMap<String, Int>, mp: Array<IntArray>, target: String): Int {
        if (dp.containsKey(target)) return dp[target] ?: -1
        var ans = Int.MAX_VALUE
        val n = mp.size
        val tar = IntArray(ALPHABET_LETTERS_COUNT)
        for (c in target.toCharArray()) tar[c - 'a']++
        // try every sticker
        for (i in 0 until n) {
            // optimization
            if (mp[i][target[0] - 'a'] == 0) continue
            val sb = StringBuilder()
            // apply a sticker on every character a-z
            for (j in 0 until ALPHABET_LETTERS_COUNT) {
                if (tar[j] > 0) for (k in 0 until max(0, tar[j] - mp[i][j])) sb.append(('a'.code + j).toChar())
            }
            val s = sb.toString()
            val tmp = helper(dp, mp, s)
            if (tmp != -1) ans = min(ans, 1 + tmp)
        }
        dp[target] = if (ans == Int.MAX_VALUE) -1 else ans
        return dp[target] ?: -1
    }
}
