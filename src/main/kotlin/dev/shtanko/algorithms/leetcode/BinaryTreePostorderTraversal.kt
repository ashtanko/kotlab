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

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList

internal fun TreeNode?.postOrderTraversal(): List<Int> {
    val result: LinkedList<Int> = LinkedList()
    val stack: Deque<TreeNode> = ArrayDeque()
    var p: TreeNode? = this
    while (stack.isNotEmpty() || p != null) {
        p = if (p != null) {
            stack.push(p)
            result.addFirst(p.value)
            p.right
        } else {
            val node = stack.pop()
            node.left
        }
    }
    return result
}
