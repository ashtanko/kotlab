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

import java.util.Deque
import java.util.LinkedList

/**
 * 1022. Sum of Root To Leaf Binary Numbers
 * @link https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
internal interface SumOfRootToLeafBinaryNumbersStrategy {
    fun sumRootToLeaf(root: TreeNode?): Int
}

internal class SumOfRootToLeafBinaryNumbersBitwise : SumOfRootToLeafBinaryNumbersStrategy {
    override fun sumRootToLeaf(root: TreeNode?): Int {
        var rootNode = root
        var rootToLeaf = 0
        var currNumber = 0
        val stack: Deque<Pair<TreeNode?, Int>> = LinkedList()
        stack.push(rootNode to 0)

        while (!stack.isEmpty()) {
            val p = stack.pop()
            rootNode = p.first
            currNumber = p.second
            if (rootNode != null) {
                currNumber = currNumber shl 1 or rootNode.value
                // if it's a leaf, update root-to-leaf sum
                if (rootNode.left == null && rootNode.right == null) {
                    rootToLeaf += currNumber
                } else {
                    stack.push(Pair(rootNode.right, currNumber))
                    stack.push(Pair(rootNode.left, currNumber))
                }
            }
        }
        return rootToLeaf
    }
}

// Iterative Preorder Traversal
internal class SumOfRootToLeafBinaryNumbersIPT : SumOfRootToLeafBinaryNumbersStrategy {
    override fun sumRootToLeaf(root: TreeNode?): Int {
        var rootToLeaf = 0
        var currNumber: Int
        var r = root
        val stack: Deque<Pair<TreeNode?, Int>> = LinkedList()
        stack.push(r to 0)

        while (!stack.isEmpty()) {
            val p = stack.pop()
            r = p.first
            currNumber = p.second
            if (r != null) {
                currNumber = currNumber shl 1 or r.value
                // if it's a leaf, update root-to-leaf sum
                if (r.left == null && r.right == null) {
                    rootToLeaf += currNumber
                } else {
                    stack.push(r.right to currNumber)
                    stack.push(r.left to currNumber)
                }
            }
        }
        return rootToLeaf
    }
}

// Recursive Preorder Traversal
internal class SumOfRootToLeafBinaryNumbersRPT : SumOfRootToLeafBinaryNumbersStrategy {
    private var rootToLeaf = 0

    override fun sumRootToLeaf(root: TreeNode?): Int {
        preorder(root, 0)
        return rootToLeaf
    }

    private fun preorder(r: TreeNode?, currNumber: Int) {
        var number = currNumber
        if (r != null) {
            number = number shl 1 or r.value
            // if it's a leaf, update root-to-leaf sum
            if (r.left == null && r.right == null) {
                rootToLeaf += number
            }
            preorder(r.left, number)
            preorder(r.right, number)
        }
    }
}

// Morris Preorder Traversal
internal class SumOfRootToLeafBinaryNumbersMPT : SumOfRootToLeafBinaryNumbersStrategy {
    override fun sumRootToLeaf(root: TreeNode?): Int {
        var rootToLeaf = 0
        var currNumber = 0
        var steps: Int
        var predecessor: TreeNode?
        var treeNode = root

        while (treeNode != null) {
            // If there is a left child,
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (treeNode.left != null) {
                // Predecessor node is one step to the left
                // and then to the right till you can.
                predecessor = treeNode.left
                steps = 1
                while (predecessor!!.right != null && predecessor.right !== treeNode) {
                    predecessor = predecessor.right
                    ++steps
                }

                // Set link predecessor.right = root
                // and go to explore the left subtree
                if (predecessor.right == null) {
                    currNumber = currNumber shl 1 or treeNode.value
                    predecessor.right = treeNode
                    treeNode = treeNode.left
                } else {
                    // If you're on the leaf, update the sum
                    if (predecessor.left == null) {
                        rootToLeaf += currNumber
                    }
                    // This part of tree is explored, backtrack
                    for (i in 0 until steps) {
                        currNumber = currNumber shr 1
                    }
                    predecessor.right = null
                    treeNode = treeNode.right
                }
            } else {
                currNumber = currNumber shl 1 or treeNode.value
                // if you're on the leaf, update the sum
                if (treeNode.right == null) {
                    rootToLeaf += currNumber
                }
                treeNode = treeNode.right
            }
        }
        return rootToLeaf
    }
}
