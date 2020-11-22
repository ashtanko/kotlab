package dev.shtanko.algorithms.leetcode

import kotlin.math.min

interface BinaryTreeCamerasStrategy {

    fun perform(root: TreeNode?): Int
}

class BinaryTreeCamerasDFS : BinaryTreeCamerasStrategy {

    companion object {
        private const val NOT_MONITORED = 0
        private const val MONITORED_NO_CAM = 1
        private const val MONITORED_WITH_CAM = 2
    }

    private var cameras = 0

    override fun perform(root: TreeNode?): Int {
        if (root == null) return 0
        val top = root.dfs()
        val local = if (top == NOT_MONITORED) 1 else 0
        return cameras + local
    }

    private fun TreeNode?.dfs(): Int {
        if (this == null) return MONITORED_NO_CAM
        val left = this.left.dfs()
        val right = this.right.dfs()
        return if (left == MONITORED_NO_CAM && right == MONITORED_NO_CAM) {
            NOT_MONITORED
        } else if (left == NOT_MONITORED || right == NOT_MONITORED) {
            cameras++
            MONITORED_WITH_CAM
        } else {
            MONITORED_NO_CAM
        }
    }
}

class BinaryTreeCamerasDP : BinaryTreeCamerasStrategy {

    companion object {
        private const val MAX_ARRAY_SIZE = 99999
    }

    override fun perform(root: TreeNode?): Int {
        val ans = solve(root)
        return min(ans[1], ans[2])
    }

    // 0: Strict ST; All nodes below this are covered, but not this one
    // 1: Normal ST; All nodes below and incl this are covered - no camera
    // 2: Placed camera; All nodes below this are covered, plus camera here
    private fun solve(node: TreeNode?): IntArray {
        if (node == null) return intArrayOf(0, 0, MAX_ARRAY_SIZE)
        val l = solve(node.left)
        val r = solve(node.right)
        val mL12 = min(l[1], l[2])
        val mR12 = min(r[1], r[2])
        val d0 = l[1] + l[1]
        val d1 = min(l[2] + mR12, r[2] + mL12)
        val d2 = 1 + min(l[0], mL12) + min(r[0], mR12)
        return intArrayOf(d0, d1, d2)
    }
}

class BinaryTreeCamerasGreedy : BinaryTreeCamerasStrategy {

    private var ans = 0
    private val covered: MutableSet<TreeNode?> = HashSet()

    override fun perform(root: TreeNode?): Int {
        covered.add(null)
        dfs(root, null)
        return ans
    }

    fun dfs(node: TreeNode?, par: TreeNode?) {
        if (node != null) {
            dfs(node.left, node)
            dfs(node.right, node)
            val leftRightPredicate = !covered.contains(node.left) || !covered.contains(node.right)
            if (par == null && !covered.contains(node) || leftRightPredicate) {
                ans++
                covered.add(node)
                covered.add(par)
                covered.add(node.left)
                covered.add(node.right)
            }
        }
    }
}
