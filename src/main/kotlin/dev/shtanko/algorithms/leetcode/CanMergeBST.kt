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

/**
 * 1932. Merge BSTs to Create Single BST
 * @link https://leetcode.com/problems/merge-bsts-to-create-single-bst/
 */
interface CanMergeBST {
    fun perform(trees: List<TreeNode>): TreeNode?
}

class CanMergeBSTImpl : CanMergeBST {

    override fun perform(trees: List<TreeNode>): TreeNode? {
        return canMerge(trees)
    }

    private fun canMerge(trees: List<TreeNode>): TreeNode? {
        val map: MutableMap<Int, TreeNode> = HashMap() // root.val -> root
        val count: MutableMap<Int, Int> = HashMap() // node.val -> count
        for (tree in trees) {
            map[tree.value] = tree
            count[tree.value] = count.getOrDefault(tree.value, 0) + 1
            if (tree.left != null) {
                count[tree.left?.value ?: 0] = count.getOrDefault(tree.left?.value, 0) + 1
            }
            if (tree.right != null) {
                count[tree.right?.value ?: 0] = count.getOrDefault(tree.right?.value, 0) + 1
            }
        }
        for (root in trees) if (count[root.value] == 1) {
            return if (traverse(root, map, Int.MIN_VALUE, Int.MAX_VALUE) && map.size == 1) root else null
        }
        return null
    }

    private fun traverse(root: TreeNode?, map: MutableMap<Int, TreeNode>, min: Int, max: Int): Boolean {
        if (root == null) return true
        if (root.value <= min || root.value >= max) return false
        if (root.left == null && root.right == null) { // leaf node
            if (map.containsKey(root.value) && root != map[root.value]) {
                val next = map[root.value]
                root.left = next?.left
                root.right = next?.right
                map.remove(root.value)
            }
        }
        return traverse(root.left, map, min, root.value) && traverse(root.right, map, root.value, max)
    }
}
