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

import java.util.LinkedList
import java.util.Stack

internal fun TreeNode?.preorderTraversal(): List<Int> {
    val list: MutableList<Int> = LinkedList()
    val stack: Stack<TreeNode> = Stack()
    var node = this
    while (node != null) {
        list.add(node.value)
        if (node.right != null) {
            stack.push(node.right)
        }
        node = node.left
        if (node == null && stack.isNotEmpty()) {
            node = stack.pop()
        }
    }

    return list
}
