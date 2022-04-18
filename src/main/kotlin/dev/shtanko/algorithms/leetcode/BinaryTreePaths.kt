/*
 * Copyright 2020 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Queue
import java.util.Stack

private const val FORMAT = "%s%s%s"
private const val ARROW = "->"

internal interface BinaryTreePathsStrategy {
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
