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

import java.util.LinkedList
import java.util.Queue

internal fun TreeNode?.levelOrder(): List<List<Int>> {
    val queue: Queue<TreeNode> = LinkedList()
    val wrapList: MutableList<MutableList<Int>> = ArrayList()
    if (this == null) return wrapList
    queue.offer(this)
    while (!queue.isEmpty()) {
        val levelNum = queue.size
        val subList: MutableList<Int> = LinkedList()
        for (i in 0 until levelNum) {
            if (queue.peek().left != null) {
                queue.offer(queue.peek().left)
            }
            if (queue.peek().right != null) {
                queue.offer(queue.peek().right)
            }
            subList.add(queue.poll().value)
        }
        wrapList.add(subList)
    }
    return wrapList
}
