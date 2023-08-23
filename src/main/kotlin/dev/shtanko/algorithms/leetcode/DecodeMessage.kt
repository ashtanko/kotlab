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

import java.util.stream.Collectors

/**
 * 2325. Decode the Message
 * https://leetcode.com/problems/decode-the-message/
 */
interface DecodeMessage {
    fun perform(key: String, message: String): String
}

class DecodeMessageBruteForce : DecodeMessage {
    override fun perform(key: String, message: String): String {
        val m: MutableMap<Char, Char> = HashMap()
        m[' '] = ' '
        var to = 'a'
        for (from in key.toCharArray()) {
            if (!m.containsKey(from)) {
                m[from] = to++
            }
        }
        return message.chars().mapToObj { c -> m[c.toChar()].toString() + "" }.collect(Collectors.joining(""))
    }
}

class DecodeMessageSB : DecodeMessage {
    override fun perform(key: String, message: String): String {
        val table = CharArray(ALPHABET_LETTERS_COUNT)
        var index = 0
        for (c in key.toCharArray()) {
            if (index < ALPHABET_LETTERS_COUNT && c != ' ' && table[c.code - 'a'.code].code == 0) {
                table[c.code - 'a'.code] = (index + 'a'.code).toChar()
                index++
            }
        }
        val sb = StringBuilder()
        for (c in message.toCharArray()) {
            sb.append(if (c == ' ') ' ' else table[c.code - 'a'.code])
        }
        return sb.toString()
    }
}
