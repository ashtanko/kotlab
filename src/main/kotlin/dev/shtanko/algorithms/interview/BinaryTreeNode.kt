package dev.shtanko.algorithms.interview

import java.util.Random

class BinaryTreeNode(private val parent: BinaryTreeNode? = null) {
    val left: WeightedTree = WeightedTree()
    val right: WeightedTree = WeightedTree()

    fun getRandom(getBetween: (range: IntRange) -> Int = { range -> range.random() }): BinaryTreeNode {
        val n = right.weight + left.weight
        return when (getBetween(0 until left.weight + right.weight + 1)) {
            in (0 until left.weight) -> left.child!!.getRandom(getBetween)
            in (left.weight until n) -> right.child!!.getRandom(getBetween)
            else -> this
        }
    }

    fun addLeftChild(newLeftChild: BinaryTreeNode) {
        require(newLeftChild.parent == this)
        left.addChild(newLeftChild)
        updateParents()
    }

    fun addRightChild(newRightChild: BinaryTreeNode) {
        require(newRightChild.parent == this)
        right.addChild(newRightChild)
        updateParents()
    }

    private fun updateParents() {
        if (parent == null) {
            return
        }

        when {
            this == parent.right.child -> parent.right.weight++
            this == parent.left.child -> parent.left.weight++
        }

        return parent.updateParents()
    }
}

class WeightedTree {
    var weight: Int = 0

    var child: BinaryTreeNode? = null
        private set

    fun addChild(binaryTreeNode: BinaryTreeNode) {
        child = binaryTreeNode
        weight++
    }
}

fun IntRange.random() =
    Random().nextInt(endInclusive.plus(1).minus(start)) + start
