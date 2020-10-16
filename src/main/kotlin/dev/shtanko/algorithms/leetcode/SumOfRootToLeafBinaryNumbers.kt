package dev.shtanko.algorithms.leetcode

import java.util.Deque
import java.util.LinkedList

internal interface SumOfRootToLeafBinaryNumbersStrategy {
    fun sumRootToLeaf(root: TreeNode?): Int
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
        var r = root

        while (r != null) {
            // If there is a left child,
            // then compute the predecessor.
            // If there is no link predecessor.right = root --> set it.
            // If there is a link predecessor.right = root --> break it.
            if (r.left != null) {
                // Predecessor node is one step to the left
                // and then to the right till you can.
                predecessor = r.left
                steps = 1
                while (predecessor!!.right != null && predecessor.right != r) {
                    predecessor = predecessor.right
                    ++steps
                }

                // Set link predecessor.right = root
                // and go to explore the left subtree
                if (predecessor.right == null) {
                    currNumber = currNumber shl 1 or r.value
                    predecessor.right = r
                    r = r.left
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
                    r = r.right
                }
            } else {
                currNumber = currNumber shl 1 or r.value
                // if you're on the leaf, update the sum
                if (r.right == null) {
                    rootToLeaf += currNumber
                }
                r = r.right
            }
        }
        return rootToLeaf
    }
}
