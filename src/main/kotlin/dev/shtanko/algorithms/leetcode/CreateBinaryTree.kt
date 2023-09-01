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

/**
 * 2196. Create Binary Tree From Descriptions
 * @see <a href="https://leetcode.com/problems/create-binary-tree-from-descriptions">leetcode page</a>
 */
fun interface CreateBinaryTree {
    operator fun invoke(descriptions: Array<IntArray>): TreeNode?
}

class CreateBinaryTreeHashMap : CreateBinaryTree {
    override operator fun invoke(descriptions: Array<IntArray>): TreeNode? {
        val map = HashMap<Int, TreeNode?>()
        val children: MutableSet<Int> = HashSet()
        for (arr in descriptions) {
            val parent = arr[0]
            val child = arr[1]
            val isLeft = arr[2]
            children.add(child)
            val node = map.getOrDefault(parent, TreeNode(parent))
            if (isLeft == 1) {
                node?.left = map.getOrDefault(child, TreeNode(child))
                map[child] = node?.left
            } else {
                node?.right = map.getOrDefault(child, TreeNode(child))
                map[child] = node?.right
            }
            map[parent] = node
        }

        var root = -1
        for (arr in descriptions) {
            if (!children.contains(arr[0])) {
                root = arr[0]
                break
            }
        }

        return map.getOrDefault(root, null)
    }
}
