package dev.shtanko.patterns.behavioral.iterator.bst

data class TreeNode<T : Comparable<T>>(var value: T, var left: TreeNode<T>? = null, var right: TreeNode<T>? = null) {

    fun insert(valToInsert: T) {
        val parent: TreeNode<T> = getParentNodeOfValueToBeInserted(valToInsert)
        parent.insertNewChild(valToInsert)
    }

    private fun getParentNodeOfValueToBeInserted(valToInsert: T): TreeNode<T> {
        var parent: TreeNode<T> = this // todo
        var curr: TreeNode<T>? = this
        while (curr != null) {
            parent = curr
            curr = curr.traverseOneLevelDown(valToInsert)
        }
        return parent
    }

    private fun traverseOneLevelDown(value: T): TreeNode<T>? {
        return if (isGreaterThan(value)) {
            left
        } else right
    }

    private fun insertNewChild(valToInsert: T) {
        if (isLessThanOrEqualTo(valToInsert)) {
            this.right = TreeNode(valToInsert)
        } else {
            this.left = TreeNode(valToInsert)
        }
    }

    private fun isGreaterThan(value: T): Boolean {
        return this.value > value
    }

    private fun isLessThanOrEqualTo(value: T): Boolean {
        return this.value.compareTo(value) < 1
    }
}
