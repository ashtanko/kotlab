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

interface InvertTreeStrategy {
    fun perform(root: TreeNode?): TreeNode?
}

class InvertTree : InvertTreeStrategy {
    override fun perform(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val queue: Queue<TreeNode> = LinkedList<TreeNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val current: TreeNode = queue.poll()
            val temp = current.left
            current.left = current.right
            current.right = temp
            if (current.left != null) queue.add(current.left)
            if (current.right != null) queue.add(current.right)
        }
        return root
    }
}

class InvertTreeRecursive : InvertTreeStrategy {
    override fun perform(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val right: TreeNode? = perform(root.right)
        val left: TreeNode? = perform(root.left)
        root.left = right
        root.right = left
        return root
    }
}
