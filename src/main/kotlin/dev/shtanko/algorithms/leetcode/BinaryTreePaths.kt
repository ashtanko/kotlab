package dev.shtanko.algorithms.leetcode

import dev.shtanko.algorithms.leetcode.BinaryTreePathsStrategy.Companion.ARROW
import dev.shtanko.algorithms.leetcode.BinaryTreePathsStrategy.Companion.FORMAT
import java.util.LinkedList
import java.util.ArrayList
import java.util.Queue
import java.util.Stack

internal interface BinaryTreePathsStrategy {
    companion object {
        const val FORMAT = "%s%s%s"
        const val ARROW = "->"
    }

    fun binaryTreePaths(root: TreeNode?): List<String>
}

internal class BinaryTreePathsRecursion : BinaryTreePathsStrategy {
    override fun binaryTreePaths(root: TreeNode?): List<String> {
        val sList: MutableList<String> = LinkedList()
        if (root == null) return sList
        if (root.left == null && root.right == null) {
            sList.add(root.value.toString())
            return sList
        }
        for (s in binaryTreePaths(root.left)) {
            sList.add(String.format(FORMAT, root.value.toString(), ARROW, s))
        }
        for (s in binaryTreePaths(root.right)) {
            sList.add(String.format(FORMAT, root.value.toString(), ARROW, s))
        }
        return sList
    }
}

internal class BinaryTreePathsBFSQueue : BinaryTreePathsStrategy {

    override fun binaryTreePaths(root: TreeNode?): List<String> {
        val list: MutableList<String> = ArrayList()
        val qNode: Queue<TreeNode> = LinkedList()
        val qStr: Queue<String> = LinkedList()
        if (root == null) return list
        qNode.add(root)
        qStr.add("")
        while (!qNode.isEmpty()) {
            val curNode: TreeNode = qNode.remove()
            val curStr: String = qStr.remove()
            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.value)
            if (curNode.left != null) {
                qNode.add(curNode.left)
                qStr.add(String.format(FORMAT, curStr, curNode.value.toString(), ARROW))
            }
            if (curNode.right != null) {
                qNode.add(curNode.right)
                qStr.add(String.format(FORMAT, curStr, curNode.value.toString(), ARROW))
            }
        }
        return list
    }
}

internal class BinaryTreePathsBFSStack : BinaryTreePathsStrategy {
    override fun binaryTreePaths(root: TreeNode?): List<String> {
        val list: MutableList<String> = ArrayList()
        val sNode: Stack<TreeNode> = Stack<TreeNode>()
        val sStr: Stack<String> = Stack<String>()

        if (root == null) return list
        sNode.push(root)
        sStr.push("")
        while (!sNode.isEmpty()) {
            val curNode: TreeNode = sNode.pop()
            val curStr: String = sStr.pop()
            if (curNode.left == null && curNode.right == null) list.add(curStr + curNode.value)
            if (curNode.left != null) {
                sNode.push(curNode.left)
                sStr.push(String.format(FORMAT, curStr, curNode.value.toString(), ARROW))
            }
            if (curNode.right != null) {
                sNode.push(curNode.right)
                sStr.push(String.format(FORMAT, curStr, curNode.value.toString(), ARROW))
            }
        }
        return list
    }
}
