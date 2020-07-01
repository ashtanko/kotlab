package dev.shtanko.datastructures.tree

import org.junit.jupiter.api.Test

class AVLTreeTest {

    @Test
    fun `empty test`() {
        val tree = AVLTree()
        for (i in 1 until 10) {
            tree.insert(i)
        }
        tree.printBalance()
    }
}
