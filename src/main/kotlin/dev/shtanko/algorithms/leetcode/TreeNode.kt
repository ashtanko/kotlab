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

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

internal fun TreeNode?.clone(): TreeNode? {
    if (this == null) return null
    val node = TreeNode(value)
    node.left = left.clone()
    node.right = right.clone()
    return node
}

/**
 * @return left height of the tree
 */
fun TreeNode?.height(): Int {
    return if (this == null) -1 else 1 + this.left.height()
}
