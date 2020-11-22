package dev.shtanko.patterns.behavioral.iterator.bst

import dev.shtanko.patterns.behavioral.iterator.CustomIterator
import java.util.ArrayDeque
import java.util.Deque

class BstIterator<T : Comparable<T>>(root: TreeNode<T>?) : CustomIterator<TreeNode<T>> {

    private val pathStack: Deque<TreeNode<T>> = ArrayDeque()

    init {
        pushPathToNextSmallest(root)
    }

    override fun hasNext(): Boolean {
        return !pathStack.isEmpty()
    }

    @Throws(NoSuchElementException::class)
    override fun next(): TreeNode<T>? {
        if (pathStack.isEmpty()) {
            throw NoSuchElementException()
        }
        val next = pathStack.pop()
        pushPathToNextSmallest(next.right)
        return next
    }

    private fun pushPathToNextSmallest(node: TreeNode<T>?) {
        var treeNode = node
        while (treeNode != null) {
            pathStack.push(treeNode)
            treeNode = treeNode.left
        }
    }
}
