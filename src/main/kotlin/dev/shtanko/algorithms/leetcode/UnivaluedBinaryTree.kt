package dev.shtanko.algorithms.leetcode

internal interface UnivaluedBinaryTreeStrategy {
    fun perform(root: TreeNode?): Boolean
}

internal class UnivaluedBinaryTreeDFS : UnivaluedBinaryTreeStrategy {

    private var values: MutableList<Int> = mutableListOf()

    override fun perform(root: TreeNode?): Boolean {
        dfs(root)
        for (value in values) {
            if (value != values.first()) return false
        }
        return true
    }

    private fun dfs(node: TreeNode?) {
        if (node != null) {
            values.add(node.value)
            dfs(node.left)
            dfs(node.right)
        }
    }
}

internal class UnivaluedBinaryTreeRecursive : UnivaluedBinaryTreeStrategy {
    override fun perform(root: TreeNode?): Boolean {
        val isLeftCorrect = root?.left == null || root.value == root.left?.value && perform(root.left)
        val isRightCorrect = root?.right == null || root.value == root.right?.value && perform(root.right)
        return isLeftCorrect && isRightCorrect
    }
}
