package dev.shtanko.algorithms.exercises

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TreeTest {

    @Test
    fun `clone tree test`() {
        val t1 = TreeNode(4)
        val t2 = TreeNode(8)
        val t3 = TreeNode(15)
        val t4 = TreeNode(16)
        val t5 = TreeNode(23)
        val t6 = TreeNode(42)

        t1.left = t2
        t1.right = t3
        t2.left = t4
        t2.right = t5
        t3.left = t6

        t1.traverseTree()
        val clone = t1.clone()
        clone.traverseTree()
        assertEquals(t1, clone)
    }
}
