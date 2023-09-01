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
 * 2326. Spiral Matrix IV
 * @see <a href="https://leetcode.com/problems/spiral-matrix-iv/">leetcode page</a>
 */
fun interface SpiralMatrix4 {
    operator fun invoke(m: Int, n: Int, head: ListNode?): Array<IntArray>
}

class WalkSpiralMatrix4 : SpiralMatrix4 {
    override operator fun invoke(m: Int, n: Int, head: ListNode?): Array<IntArray> {
        var h = head
        val spiral = Array(m) { IntArray(n) { -1 } }
        var r = 0
        var c = 0
        var ri = 0
        var ci = 1
        while (h != null) {
            spiral[r][c] = h.value
            h = h.next
            if (spiral[(r + ri + m) % m][(c + ci + n) % n] != -1) {
                val temp = ri
                ri = ci
                ci = -temp
            }
            r += ri
            c += ci
        }
        return spiral
    }
}
