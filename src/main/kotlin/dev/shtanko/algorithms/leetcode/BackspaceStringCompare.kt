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

import java.util.Stack

/**
 * 844. Backspace String Compare
 * @see <a href="https://leetcode.com/problems/backspace-string-compare">Source</a>
 */
fun interface BackspaceStringCompare {
    operator fun invoke(s: String, t: String): Boolean
}

class BackspaceStringCompareStack : BackspaceStringCompare {
    override fun invoke(s: String, t: String): Boolean {
        return build(s) == build(t)
    }

    private fun build(s: String): String {
        val ans: Stack<Char> = Stack()
        for (c in s.toCharArray()) {
            if (c != '#') {
                ans.push(c)
            } else if (!ans.empty()) {
                ans.pop()
            }
        }
        return java.lang.String.valueOf(ans)
    }
}

class BackspaceStringCompareTwoPointer : BackspaceStringCompare {
    override fun invoke(s: String, t: String): Boolean {
        var i: Int = s.length - 1
        var j: Int = t.length - 1
        var skipS = 0
        var skipT = 0

        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (s[i] == '#') {
                    skipS++
                    i--
                } else if (skipS > 0) {
                    skipS--
                    i--
                } else {
                    break
                }
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (t[j] == '#') {
                    skipT++
                    j--
                } else if (skipT > 0) {
                    skipT--
                    j--
                } else {
                    break
                }
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && s[i] != t[j]) return false
            // If expecting to compare char vs nothing
            if (i >= 0 != j >= 0) return false
            i--
            j--
        }
        return true
    }
}
