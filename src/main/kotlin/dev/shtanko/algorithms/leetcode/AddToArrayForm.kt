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

import java.util.LinkedList

/**
 * 989. Add to Array-Form of Integer
 * @see <a href="https://leetcode.com/problems/add-to-array-form-of-integer/">leetcode page</a>
 */
interface AddToArrayForm {
    fun perform(num: IntArray, k: Int): List<Int>
}

class AddToArrayFormSimple : AddToArrayForm {
    override fun perform(num: IntArray, k: Int): List<Int> {
        val res: MutableList<Int> = LinkedList()
        var k0 = k
        for (i in num.size - 1 downTo 0) {
            res.add(0, (num[i] + k0) % DECIMAL)
            k0 = (num[i] + k0) / DECIMAL
        }
        while (k0 > 0) {
            res.add(0, k0 % DECIMAL)
            k0 /= DECIMAL
        }
        return res
    }
}

class AddToArrayFormOnePass : AddToArrayForm {
    override fun perform(num: IntArray, k: Int): List<Int> {
        val res: MutableList<Int> = LinkedList()
        var i: Int = num.size - 1
        var k0 = k
        while (i >= 0 || k0 > 0) {
            res.add(0, (if (i >= 0) num[i] + k0 else k0) % DECIMAL)
            k0 = (if (i >= 0) num[i] + k0 else k0) / DECIMAL
            --i
        }
        return res
    }
}
