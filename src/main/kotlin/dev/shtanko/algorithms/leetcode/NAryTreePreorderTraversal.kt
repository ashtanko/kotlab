package dev.shtanko.algorithms.leetcode

import java.util.ArrayList
import java.util.Stack

internal class NAryNode(var value: Int) {
    var children: List<NAryNode?> = listOf()
}

internal interface NAryTreePreorderTraversalStrategy {
    fun preorder(root: NAryNode?): List<Int>
}

internal class NAryTreePreorderTraversalIterative : NAryTreePreorderTraversalStrategy {
    override fun preorder(root: NAryNode?): List<Int> {
        var r = root
        val list: MutableList<Int> = ArrayList()
        if (r == null) return list

        val stack: Stack<NAryNode> = Stack()
        stack.add(r)

        while (!stack.empty()) {
            r = stack.pop()
            list.add(r.value)
            for (i in r.children.size - 1 downTo 0) stack.add(r.children[i])
        }

        return list
    }
}

internal class NAryTreePreorderTraversalRecursive : NAryTreePreorderTraversalStrategy {

    var list: MutableList<Int> = ArrayList()

    override fun preorder(root: NAryNode?): List<Int> {
        if (root == null) return list
        list.add(root.value)
        for (node in root.children) preorder(node)
        return list
    }
}
