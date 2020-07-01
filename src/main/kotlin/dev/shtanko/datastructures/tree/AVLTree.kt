package dev.shtanko.datastructures.tree

import org.slf4j.LoggerFactory

class AVLTree {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(AVLTree::class.java)
        private const val PRINT_FORMAT = "%s"
        private const val TWO = 2
    }

    data class Node(
        val key: Int,
        var balance: Int? = null,
        var height: Int? = null,
        var left: Node? = null,
        var right: Node? = null,
        var parent: Node? = null
    )

    private var root: Node? = null

    fun insert(key: Int): Boolean {
        if (root == null) {
            root = Node(key = key, parent = null)
        } else {
            var n = root
            var parent: Node?
            while (true) {
                if (n?.key == key) {
                    return false
                }
                parent = n
                val goLeft = if (n == null) false else n.key > key

                n = if (goLeft) {
                    n?.left
                } else {
                    n?.right
                }
                if (n == null) {
                    if (goLeft) {
                        parent?.left = Node(key = key, parent = parent)
                    } else {
                        parent?.right = Node(key = key, parent = parent)
                    }
                    rebalance(parent)
                    break
                }
            }
        }

        return true
    }

    private fun rebalance(n: Node?) {
        var node = n
        setBalance(node)
        if (node?.balance == -TWO) {
            node = if (height(node.left?.left) >= height(node.left?.right)) rotateRight(n) else rotateLeftThenRight(n)
        } else if (n?.balance == TWO) {
            node = if (height(n.right?.right) >= height(n.right?.left)) rotateLeft(n) else rotateRightThenLeft(n)
        }
        if (n?.parent != null) {
            rebalance(n.parent)
        } else {
            root = node
        }
    }

    fun printBalance() {
        printBalance(root)
    }

    private fun rotateLeft(a: Node?): Node? {
        val b = a?.right
        b?.parent = a?.parent
        a?.right = b?.left
        if (a?.right != null) {
            a.right?.parent = a
        }
        b?.left = a
        a?.parent = b
        if (b?.parent != null) {
            if (b.parent?.right === a) {
                b.parent?.right = b
            } else {
                b.parent?.left = b
            }
        }
        setBalance(a, b)
        return b
    }

    private fun rotateRight(a: Node?): Node? {
        val b = a?.left
        b?.parent = a?.parent
        a?.left = b?.right
        if (a?.left != null) {
            a.left?.parent = a
        }
        b?.right = a
        a?.parent = b
        if (b?.parent != null) {
            if (b.parent?.right === a) {
                b.parent?.right = b
            } else {
                b.parent?.left = b
            }
        }
        setBalance(a, b)
        return b
    }

    private fun rotateLeftThenRight(n: Node?): Node? {
        n?.left = rotateLeft(n?.left)
        return rotateRight(n)
    }

    private fun rotateRightThenLeft(n: Node?): Node? {
        n?.right = rotateRight(n?.right)
        return rotateLeft(n)
    }

    private fun printBalance(n: Node?) {
        if (n != null) {
            printBalance(n.left)
            LOGGER.info(String.format(PRINT_FORMAT, n.balance))
            printBalance(n.right)
        }
    }

    private fun setBalance(vararg nodes: Node?) {
        for (node in nodes) {
            reheight(node)
            node?.balance = height(node?.right) - height(node?.left)
        }
    }

    private fun reheight(node: Node?) {
        if (node == null) {
            node?.height = 1 + height(node?.left).coerceAtLeast(height(node?.right))
        }
    }

    private fun height(n: Node?): Int {
        if (n == null) {
            return -1
        }
        return n.height ?: -1
    }
}
