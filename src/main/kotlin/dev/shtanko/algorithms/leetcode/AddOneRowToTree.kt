/*
 * Copyright 2021 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
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
import java.util.Stack

/**
 * 623. Add One Row to Tree
 * @see <a href="https://leetcode.com/problems/add-one-row-to-tree/">Source</a>
 */
fun interface AddOneRowToTree {
    operator fun invoke(root: TreeNode?, v: Int, d: Int): TreeNode?
}

/**
 * Approach #1 Using Recursion(DFS)
 */
class AddOneRowToTreeRec : AddOneRowToTree {
    /**
     * Adds a row with a specified value to a binary tree at a specified depth.
     *
     * @param root The root of the binary tree.
     * @param v The value to be inserted in the new nodes.
     * @param d The depth at which the new row should be inserted.
     * @return The modified binary tree with the new row inserted.
     */
    override operator fun invoke(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            return TreeNode(v).apply {
                left = root
                right = null
            }
        }
        return insert(root, v, d - 1, 1)
    }

    /**
     * Inserts a node into a binary tree at a specified depth with a specified value.
     *
     * @param node The root of the binary tree or sub-tree.
     * @param value The value to be inserted in the new nodes.
     * @param depth The depth at which the new nodes should be inserted.
     * @param n The current depth of the tree.
     * @return The modified binary tree with the new nodes inserted.
     */
    private fun insert(node: TreeNode?, value: Int, depth: Int, n: Int): TreeNode? {
        if (node == null) {
            return node
        }
        if (depth == n) {
            node.left = TreeNode(value).apply {
                left = node.left
                right = null
            }
            node.right = TreeNode(value).apply {
                left = null
                right = node.right
            }
        }
        node.left = insert(node.left, value, depth, n + 1)
        node.right = insert(node.right, value, depth, n + 1)
        return node
    }
}

/**
 * Approach #2 Using stack(DFS)
 */
class AddOneRowToTreeStack : AddOneRowToTree {

    data class Node(val node: TreeNode?, val depth: Int)

    override operator fun invoke(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            return TreeNode(v).apply {
                left = root
            }
        }
        val stack = Stack<Node>()
        stack.push(Node(root, 1))
        while (stack.isNotEmpty()) {
            val n = stack.pop()
            if (n.node == null) {
                continue
            }
            if (n.depth == d - 1) {
                var tmp = n.node.left
                n.node.left = TreeNode(v)
                n.node.left?.left = tmp
                tmp = n.node.right
                n.node.right = TreeNode(v)
                n.node.right?.right = tmp
            } else {
                stack.push(Node(n.node.left, n.depth + 1))
                stack.push(Node(n.node.right, n.depth + 1))
            }
        }
        return root
    }
}

/**
 * Approach #3 Using queue(BFS)
 */
class AddOneRowToTreeQueue : AddOneRowToTree {
    override operator fun invoke(root: TreeNode?, v: Int, d: Int): TreeNode? {
        if (d == 1) {
            return TreeNode(v).apply {
                left = root
            }
        }
        var queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)
        var depth = 1
        while (depth < d - 1) {
            val temp: Queue<TreeNode?> = LinkedList()
            while (queue.isNotEmpty()) {
                val node = queue.remove()
                if (node?.left != null) {
                    temp.add(node.left)
                }
                if (node?.right != null) {
                    temp.add(node.right)
                }
            }
            queue = temp
            depth++
        }

        while (queue.isNotEmpty()) {
            val node = queue.remove()
            var tmp = node?.left
            node?.left = TreeNode(v)
            node?.left?.left = tmp
            tmp = node?.right
            node?.right = TreeNode(v)
            node?.right?.right = tmp
        }
        return root
    }
}
