package dev.shtanko.datastructures.tree

import java.util.Collections.swap

/**
 * Binary heap implementation
 */
class Heap<T>(private val comparator: Comparator<T>) {

    private val tree: MutableList<T?> = ArrayList()

    init {
        tree.add(null)
    }

    fun add(elem: T) {
        tree.add(elem)
        siftUp()
    }

    fun peek(): T? {
        return tree.getOrNull(1)
    }

    fun poll(): T? {
        if (tree.isEmpty()) return null
        val result = tree[1]
        tree[1] = tree.last()
        tree.removeAt(tree.lastIndex)
        siftDown()
        return result
    }

    private fun siftUp() {
        var index = tree.lastIndex
        var ancestor = getAncestor(index)
        while (ancestor > 0 && comparator.compare(tree[ancestor], tree[index]) > 0) {
            swap(tree, ancestor, index)
            index = ancestor
            ancestor = getAncestor(index)
        }
    }

    private fun siftDown() {
        var index = 1
        while (index < tree.size) {
            val leftChildIndex = getLeftChild(index)
            val rightChildIndex = getRightChild(index)
            val leftChild = tree.getOrNull(leftChildIndex)
            val rightChild = tree.getOrNull(rightChildIndex)
            val shouldContinue = !checkPredicate(tree[index]!!, leftChild, rightChild)
            if (shouldContinue) {
                val predicate = rightChild != null && comparator.compare(leftChild, rightChild) > 0
                val nextIndex: Int = if (leftChild == null || predicate) {
                    rightChildIndex
                } else {
                    leftChildIndex
                }

                swap(tree, index, nextIndex)
                index = nextIndex
            } else break
        }
    }

    private fun checkPredicate(root: T, left: T?, right: T?): Boolean {
        if (left != null && comparator.compare(root, left) > 0) {
            return false
        }

        if (right != null && comparator.compare(root, right) > 0) {
            return false
        }

        return true
    }

    private fun getAncestor(index: Int): Int {
        return index / 2
    }

    private fun getLeftChild(index: Int): Int {
        return index * 2
    }

    private fun getRightChild(index: Int): Int {
        return index * 2 + 1
    }

    fun size(): Int {
        return tree.size - 1
    }
}
