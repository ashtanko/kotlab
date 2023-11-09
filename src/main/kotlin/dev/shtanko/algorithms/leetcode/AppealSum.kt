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

import dev.shtanko.algorithms.ALPHABET_LETTERS_COUNT

/**
 * 2262. Total Appeal of A String
 * @see <a href="https://leetcode.com/problems/total-appeal-of-a-string/">Source</a>
 */
fun interface AppealSum {
    operator fun invoke(s: String): Long
}

class AppealSumDP : AppealSum {

    override operator fun invoke(s: String): Long {
        var res: Long = 0
        var cur: Long = 0
        val prev = LongArray(ALPHABET_LETTERS_COUNT)
        for (i in s.indices) {
            cur += i + 1 - prev[s[i] - 'a']
            prev[s[i] - 'a'] = (i + 1).toLong()
            res += cur
        }
        return res
    }
}

class AppealSumDPKt : AppealSum {
    override operator fun invoke(s: String): Long {
        var cur: Long = 0
        val prev = LongArray(ALPHABET_LETTERS_COUNT)
        return s.mapIndexed { index, c ->
            cur += index + 1 - prev[c - 'a']
            prev[c - 'a'] = index.toLong() + 1
            cur
        }.sum()
    }
}
