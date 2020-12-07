package dev.shtanko.algorithms.leetcode

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList
import java.util.Queue

// Find Nearest Right Node in Binary Tree
interface FindNearestRightNodeStrategy {
    fun perform(root: TreeNode?, u: TreeNode?): TreeNode?
}

// Approach 1: BFS: Two Queues
class FindNearestRightNodeTwoQueues : FindNearestRightNodeStrategy {

    override fun perform(root: TreeNode?, u: TreeNode?): TreeNode? {
        val nextLevel: ArrayDeque<TreeNode?> = ArrayDeque()
        root?.let {
            nextLevel.offer(it)
        }

        var currLevel: ArrayDeque<TreeNode?>
        var node: TreeNode?
        while (!nextLevel.isEmpty()) {
            // prepare for the next level
            currLevel = nextLevel.clone()
            nextLevel.clear()
            while (!currLevel.isEmpty()) {
                node = currLevel.poll()
                if (node.levelOrder().flatten() == u.levelOrder().flatten()) {
                    return currLevel.poll()
                }

                // add child nodes of the current level
                // in the queue for the next level
                if (node?.left != null) nextLevel.offer(node.left!!)
                if (node?.right != null) nextLevel.offer(node.right!!)
            }
        }
        return null
    }
}

// Approach 2: BFS: One Queue + Sentinel
class FindNearestRightNodeSentinel : FindNearestRightNodeStrategy {
    override fun perform(root: TreeNode?, u: TreeNode?): TreeNode? {
        val queue: Queue<TreeNode?> = LinkedList()
        root?.let {
            queue.offer(it)
        }
        queue.offer(null)

        var curr: TreeNode? = null

        while (!queue.isEmpty()) {
            curr = queue.poll()
            if (curr != null) {
                // if it's the given node
                if (curr.levelOrder().flatten() == u.levelOrder().flatten()) return queue.poll()

                // add child nodes in the queue
                if (curr.left != null) {
                    queue.offer(curr.left)
                }
                if (curr.right != null) {
                    queue.offer(curr.right)
                }
            } else {
                // add a sentinel to mark end of level
                if (!queue.isEmpty()) queue.offer(null)
            }
        }
        return curr
    }
}

// Approach 3: BFS: One Queue + Level Size Measurements
class FindNearestRightNodeSizeMeasurements : FindNearestRightNodeStrategy {
    override fun perform(root: TreeNode?, u: TreeNode?): TreeNode? {
        val queue: Deque<TreeNode> = ArrayDeque()
        root?.let {
            queue.offer(it)
        }
        while (!queue.isEmpty()) {
            val levelLength: Int = queue.size
            for (i in 0 until levelLength) {
                val node: TreeNode = queue.poll()
                // if it's the given node
                if (node.levelOrder().flatten() == u.levelOrder().flatten()) {
                    return if (i != levelLength - 1) queue.poll() else null
                }

                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
        }
        return null
    }
}

// Approach 4: Recursive DFS: Preorder Traversal
class FindNearestRightNodeSizePreorderTraversal : FindNearestRightNodeStrategy {

    private var uDepth = -1
    private var nextNode: TreeNode? = null
    private var u: TreeNode? = null

    override fun perform(root: TreeNode?, u: TreeNode?): TreeNode? {
        this.u = u
        preorder(root, 0)
        return nextNode
    }

    private fun preorder(node: TreeNode?, depth: Int) {
        // the depth to look for next node is identified
        if (node.levelOrder().flatten() == u.levelOrder().flatten()) {
            uDepth = depth
            // we're on the level to look for the next node
        } else if (depth == uDepth) {
            // if this next node is not identified yet
            if (nextNode == null) nextNode = node
        } else {
            // continue to traverse the tree
            if (node?.left != null) preorder(node.left!!, depth + 1)
            if (node?.right != null) preorder(node.right!!, depth + 1)
        }
    }
}
