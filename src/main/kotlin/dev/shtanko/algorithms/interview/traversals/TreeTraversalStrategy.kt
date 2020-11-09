package dev.shtanko.algorithms.interview.traversals

interface TreeTraversalStrategy {
    fun inOrderIterative(root: BinaryTreeNode): List<Int>
    fun inOrderIterativeStack(root: BinaryTreeNode): List<Int>
}
