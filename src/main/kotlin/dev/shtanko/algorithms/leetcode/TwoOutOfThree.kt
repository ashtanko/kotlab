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
import java.util.stream.IntStream

/**
 * 2032. Two Out of Three
 * link https://leetcode.com/problems/two-out-of-three/
 */
interface TwoOutOfThree {
    fun perform(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int>

    companion object {
        const val ARR_SIZE = 101
    }
}

class TwoOutOfThreeImpl : TwoOutOfThree {
    override fun perform(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        val list: MutableList<Int> = ArrayList()
        val count = Array(3) { IntArray(TwoOutOfThree.ARR_SIZE) }
        for (n in nums1) count[0][n] = 1
        for (n in nums2) count[1][n] = 1
        for (n in nums3) count[2][n] = 1

        for (i in 1 until TwoOutOfThree.ARR_SIZE) {
            if (count[0][i] + count[1][i] + count[2][i] > 1) list.add(i)
        }
        return list
    }
}

class TwoOutOfThreeStream : TwoOutOfThree {
    override fun perform(nums1: IntArray, nums2: IntArray, nums3: IntArray): List<Int> {
        val a = arrayOf(nums1, nums2, nums3)
        val c = Array(3) { IntArray(TwoOutOfThree.ARR_SIZE) }
        for (i in a.indices) for (n in a[i]) c[i][n] = 1
        return IntStream.range(1, TwoOutOfThree.ARR_SIZE).filter { n -> c[0][n] + c[1][n] + c[2][n] >= 2 }.boxed()
            .collect(Collectors.toList())
    }
}
