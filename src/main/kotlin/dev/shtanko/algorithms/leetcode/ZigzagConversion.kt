/*
 * Copyright 2023 Oleksii Shtanko
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
 * 6. Zigzag Conversion
 * @link https://leetcode.com/problems/zigzag-conversion/
 */
interface ZigzagConversion {
    fun convert(s: String, numRows: Int): String
}

class ZigzagConversionSB : ZigzagConversion {
    override fun convert(s: String, numRows: Int): String {
        if (numRows <= 1) return s
        val sb = arrayOfNulls<StringBuilder>(numRows)
        for (i in 0 until numRows) sb[i] = StringBuilder()
        var idx = 0
        var k = 1
        for (c in s.toCharArray()) {
            sb[idx]?.append(c)
            if (idx == 0) k = 1
            if (idx == numRows - 1) k = -1
            idx += k
        }
        return sb.joinToString("")
    }
}
