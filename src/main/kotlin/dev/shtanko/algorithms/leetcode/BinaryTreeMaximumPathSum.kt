/*
 * Copyright 2020 Alexey Shtanko
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

object BinaryTreeMaximumPathSum {

    private var maxValue = Int.MIN_VALUE

    internal fun TreeNode?.maxPathSum(): Int {
        maxValue = Int.MIN_VALUE
        this.maxPathDown()
        return maxValue
    }

    private fun TreeNode?.maxPathDown(): Int {
        if (this == null) return 0
        val left = 0.coerceAtLeast(this.left.maxPathDown())
        val right = 0.coerceAtLeast(this.right.maxPathDown())
        maxValue = maxValue.coerceAtLeast(left + right + this.value)
        return left.coerceAtLeast(right) + this.value
    }
}
