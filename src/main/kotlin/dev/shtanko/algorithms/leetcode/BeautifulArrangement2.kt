/*
 * Copyright 2021 Alexey Shtanko
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

interface BeautifulArrangement2 {
    fun constructArray(n: Int, k: Int): IntArray
}

/**
 * Approach #2: Construction
 */
class BA2Construction : BeautifulArrangement2 {
    override fun constructArray(n: Int, k: Int): IntArray {
        val ans = IntArray(n)
        var c = 0
        for (v in 1 until n - k) {
            ans[c++] = v
        }
        for (i in 0..k) {
            ans[c++] = if (i % 2 == 0) n - k + i / 2 else n - i / 2
        }
        return ans
    }
}
