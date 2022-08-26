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

/**
 * Merge Two Binary Trees
 */
internal fun Pair<TreeNode?, TreeNode?>.mergeTrees(): TreeNode? {
    return if (first == null && second == null) {
        null
    } else if (second == null) {
        first
    } else if (first == null) {
        second
    } else {
        val t = second?.value?.let { it -> first?.value?.plus(it)?.let { TreeNode(it) } }
        t?.left = (first?.left to second?.left).mergeTrees()
        t?.right = (first?.right to second?.right).mergeTrees()
        t
    }
}
