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
 * 752. Open the Lock
 * @see <a href="https://leetcode.com/problems/open-the-lock/">Source</a>
 */
fun interface OpenLock {
    fun openLock(deadEnds: Array<String>, target: String): Int
}

class OpenLockBFS : OpenLock {
    private var begin: MutableSet<String> = HashSet<String>().apply {
        add(START_LOCK_POSITION)
    }
    private var end: MutableSet<String> = HashSet()

    override fun openLock(deadEnds: Array<String>, target: String): Int {
        val deads: MutableSet<String> = HashSet(deadEnds.toList())
        end.add(target)
        var level = 0
        var temp: MutableSet<String>
        while (begin.isNotEmpty() && end.isNotEmpty()) {
            if (begin.size > end.size) {
                temp = begin
                begin = end
                end = temp
            }
            temp = HashSet()
            for (s in begin) {
                if (end.contains(s)) {
                    return level
                }
                if (deads.contains(s)) {
                    continue
                }
                deads.add(s)
                val sb = StringBuilder(s)
                for (i in 0 until LOCK_SIZE) {
                    val c = sb[i]
                    val s1 = sb.substring(0, i) + (if (c == '9') 0 else c - '0' + 1) + sb.substring(
                        i + 1,
                    )
                    val s2 = sb.substring(0, i) + (if (c == '0') 9 else c - '0' - 1) + sb.substring(
                        i + 1,
                    )
                    if (!deads.contains(s1)) {
                        temp.add(s1)
                    }
                    if (!deads.contains(s2)) {
                        temp.add(s2)
                    }
                }
            }
            level++
            begin = temp
        }
        return DEFAULT_RESULT
    }

    companion object {
        private const val START_LOCK_POSITION = "0000"
        private const val LOCK_SIZE = 4
        private const val DEFAULT_RESULT = -1
    }
}
