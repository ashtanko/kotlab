package dev.shtanko.algorithms.leetcode

import java.util.LinkedList
import java.util.Queue

interface EvenOddTreeStrategy {
    fun perform(tree: TreeNode?): Boolean
}

class EvenOddTreeBSF : EvenOddTreeStrategy {
    override fun perform(tree: TreeNode?): Boolean {
        var root: TreeNode? = tree ?: return true
        val q: Queue<TreeNode> = LinkedList()
        q.add(root)
        var even = true
        while (q.size > 0) {
            var size: Int = q.size
            var prevVal = if (even) Int.MIN_VALUE else Int.MAX_VALUE // init preVal based on level even or odd
            while (size-- > 0) { // level by level
                root = q.poll()
                if (even && (root.value % 2 == 0 || root.value <= prevVal)) return false // invalid case on even level
                if (!even && (root.value % 2 == 1 || root.value >= prevVal)) return false // invalid case on odd level
                prevVal = root.value // update the prev value
                if (root.left != null) q.add(root.left) // add left child if exist
                if (root.right != null) q.add(root.right) // add right child if exist
            }
            even = !even // alter the levels
        }

        return true
    }
}
