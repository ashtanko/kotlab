package dev.shtanko.algorithms.leetcode

object BinaryTreeCameras {
    private const val NOT_MONITORED = 0
    private const val MONITORED_NO_CAM = 1
    private const val MONITORED_WITH_CAM = 2
    private var cameras = 0

    internal fun TreeNode?.minCameraCover(): Int {
        if (this == null) return 0
        val top = this.dfs()
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
