package dev.shtanko.algorithms.interview.traversals

import java.util.LinkedList
import java.util.Stack

class BinaryTreeNode(
    var left: BinaryTreeNode? = null,
    var right: BinaryTreeNode? = null,
    val data: Int
) {

    var parent: BinaryTreeNode? = null

    init {
        left?.parent = this
        right?.parent = this
    }

    fun isRightChild(): Boolean = this.parent!!.right == this
}

class TreeTraversal : TreeTraversalStrategy {
    override fun inOrderIterative(root: BinaryTreeNode): List<Int> {
        var node: BinaryTreeNode? = getLeftmost(root)
        val list = LinkedList<Int>()

        while (node != null) {
            list.add(node.data)

            val right = node.right
            if (right != null) {
                node = getLeftmost(right)
            } else {
                while (node!!.parent != null && node.isRightChild()) {
                    node = node.parent
                }

                node = node.parent
            }
        }
        return list
    }

    override fun inOrderIterativeStack(root: BinaryTreeNode): List<Int> {
        val stack = Stack<BinaryTreeNode>()
        var current: BinaryTreeNode? = root
        val list = LinkedList<Int>()

        while (!stack.empty() || current != null) {
            if (current != null) {
                stack.push(current)
                current = current.left
            } else {
                current = stack.pop()
                list.add(current.data)
                current = current.right
            }
        }
        return list
    }

    private fun getLeftmost(startingNode: BinaryTreeNode): BinaryTreeNode {
        var node = startingNode
        while (node.left != null) {
            node = node.left!!
        }

        return node
    }
}
