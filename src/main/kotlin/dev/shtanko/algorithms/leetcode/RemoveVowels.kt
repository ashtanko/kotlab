/*
 * Copyright 2020 Oleksii Shtanko
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

import dev.shtanko.algorithms.extensions.isVowel

interface RemoveVowels {
    fun perform(s: String): String
}

/**
 * Time complexity: O(n).
 * Space complexity: O(1).
 */
class RemoveVowelsBruteForce : RemoveVowels {
    override fun perform(s: String): String {
        val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')
        val sb = StringBuilder()
        for (str in s) {
            if (!vowels.contains(str)) {
                sb.append(str)
            }
        }
        return sb.toString()
    }
}

class RemoveVowelsStringBuffer : RemoveVowels {
    override fun perform(s: String): String {
        val sb = StringBuffer(s.length)
        for (c in s) {
            if (c.isVowel().not()) sb.append(c)
        }
        return sb.toString()
    }
}

class RemoveVowelsFilter : RemoveVowels {
    override fun perform(s: String): String = s.filter { !it.isVowel() }
}

class RemoveVowelsReplace : RemoveVowels {
    override fun perform(s: String): String {
        return s.replace("[aeiou]".toRegex(), "")
    }
}
