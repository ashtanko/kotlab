package dev.shtanko.algorithms.leetcode

import java.lang.StringBuilder
import java.util.Stack

internal interface ConstructStringFromBinaryTreeStrategy {
    fun perform(t: TreeNode?): String
}

internal class ConstructStringFromBinaryTreeRecursion : ConstructStringFromBinaryTreeStrategy {
    override fun perform(t: TreeNode?): String {
        if (t == null) return ""
        if (t.left == null && t.right == null) return "${t.value}"
        val leftFormat = "%s(%s)"
        val leftToRightValueFormat = "%s(%s)(%s)"
        val leftValue = String.format(leftFormat, "${t.value}", perform(t.left))
        val leftToRightValue = String.format(leftToRightValueFormat, "${t.value}", perform(t.left), perform(t.right))
        return if (t.right == null) leftValue
        else leftToRightValue
    }
}

internal class ConstructStringFromBinaryTreeStack : ConstructStringFromBinaryTreeStrategy {
    override fun perform(t: TreeNode?): String {
        var tree: TreeNode? = t ?: return ""
        val stack: Stack<TreeNode> = Stack()
        stack.push(tree)
        val visited: MutableSet<TreeNode> = HashSet()
        val s = StringBuilder()
        while (!stack.isEmpty()) {
            tree = stack.peek()
            if (visited.contains(tree)) {
                stack.pop()
                s.append(")")
            } else {
                visited.add(tree)
                s.append("(" + tree.value)
                if (tree.left == null && tree.right != null) s.append("()")
                if (tree.right != null) stack.push(tree.right)
                if (tree.left != null) stack.push(tree.left)
            }
        }
        return s.substring(1, s.length - 1)
    }
}
