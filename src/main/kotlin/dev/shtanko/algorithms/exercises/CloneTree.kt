package dev.shtanko.algorithms.exercises

data class TreeNode(
    var value: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun TreeNode?.traverseTree() {
    if (this != null) {
        this.left.traverseTree()
        this.right.traverseTree()
        println(this.value)
    }
}

fun TreeNode.clone(): TreeNode {
    val dup = TreeNode(value)
    dup.left = this.left?.clone()
    dup.right = this.right?.clone()
    return dup
}
