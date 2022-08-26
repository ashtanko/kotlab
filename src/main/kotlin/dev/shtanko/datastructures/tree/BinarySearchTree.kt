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

package dev.shtanko.datastructures.tree

import dev.shtanko.datastructures.Queue

/**
 * A custom implementation of BinarySearchTree
 */
class BinarySearchTree<K : Comparable<K>, V> : Map<K, V> {

    data class Node<K, V>(
        override val key: K,
        override var value: V,
        var left: Node<K, V>? = null,
        var right: Node<K, V>? = null,
        var size: Int = 1,
    ) : Map.Entry<K, V>

    private var root: Node<K, V>? = null

    override val size: Int
        get() = size(root)

    override val entries: Set<Map.Entry<K, V>>
        get() {
            val set = mutableSetOf<Node<K, V>>()
            inorder(root) { set.add(it.copy()) }
            return set
        }

    override val keys: Set<K>
        get() {
            val set = mutableSetOf<K>()
            inorder(root) { set.add(it.key) }
            return set
        }

    override val values: Collection<V>
        get() {
            val queue = Queue<V>()
            inorder(root) { queue.add(it.value) }
            return queue
        }

    override fun containsKey(key: K): Boolean {
        return get(key) != null
    }

    override fun containsValue(value: V): Boolean {
        return any { it.value == value }
    }

    override fun get(key: K): V? {
        var x = root
        while (x != null) {
            x = when {
                key < x.key -> x.left
                key > x.key -> x.right
                else -> return x.value
            }
        }
        return null
    }

    override fun isEmpty(): Boolean = size == 0

    /**
     * @return height of the tree.
     */
    fun height(): Int {
        return height(root)
    }

    /**
     * @return min value of the tree.
     */
    fun min(): K {
        return min(root).key
    }

    /**
     * Add new [BinarySearchTree.Node].
     * @param key a key of the tree [K].
     * @param value a key of the tree [V].
     */
    fun add(key: K, value: V) {
        root = add(key, value, root)
    }

    /**
     * @return max value of the tree.
     */
    fun max(): K {
        return max(root).key
    }

    /**
     * Removes node by key [K].
     * @param key a key [K].
     */
    fun remove(key: K) {
        root = remove(key, root)
    }

    /**
     * TODO
     */
    fun pollMin() {
        if (root == null) throw NoSuchElementException()
        root = pollMin(root!!)
    }

    /**
     * TODO
     */
    fun pollMax() {
        if (root == null) throw NoSuchElementException()
        root = pollMax(root!!)
    }

    /**
     * TODO
     */
    private fun pollMax(x: Node<K, V>): Node<K, V>? {
        if (x.right == null) return x.left
        x.right = pollMax(x.right!!)
        x.size = size(x.left) + size(x.right) + 1
        return x
    }

    /**
     * TODO
     */
    private fun max(node: Node<K, V>?): Node<K, V> {
        if (node == null) throw NoSuchElementException()
        var x: Node<K, V> = node
        while (x.right != null) {
            x = x.right!!
        }
        return x
    }

    /**
     * TODO
     */
    private fun min(node: Node<K, V>?): Node<K, V> {
        if (node == null) throw NoSuchElementException()
        var x: Node<K, V> = node
        while (x.left != null) {
            x = x.left!!
        }
        return x
    }

    /**
     * TODO
     */
    private fun height(x: Node<K, V>?): Int {
        if (x == null) return 0
        return maxOf(height(x.left), height(x.right)) + 1
    }

    /**
     * TODO
     */
    private fun remove(key: K, root: Node<K, V>?): Node<K, V>? {
        var x: Node<K, V> = root ?: throw NoSuchElementException()
        when {
            key < x.key -> x.left = remove(key, x.left)
            key > x.key -> x.right = remove(key, x.right)
            else -> {
                if (x.left == null) return x.right
                if (x.right == null) return x.left
                val tmp = x
                x = pollMin(tmp.right!!)!!
                x.right = min(tmp.right)
                x.left = tmp.left
            }
        }
        x.size = size(x.left) + size(x.right) + 1
        return x
    }

    /**
     * TODO
     */
    private fun pollMin(x: Node<K, V>): Node<K, V>? {
        if (x.left == null) return x.right
        x.left = pollMin(x.left!!)
        x.size = size(x.left) + size(x.right) + 1
        return x
    }

    /**
     * TODO
     */
    private fun add(key: K, value: V, x: Node<K, V>?): Node<K, V> {
        if (x == null) return Node(key, value)
        when {
            key < x.key -> x.left = add(key, value, x.left)
            key > x.key -> x.right = add(key, value, x.right)
            else -> x.value = value
        }
        x.size = size(x.left) + size(x.right) + 1
        return x
    }

    /**
     * @return size of the tree.
     */
    private fun size(x: Node<K, V>?): Int = x?.size ?: 0

    /**
     * TODO
     */
    private fun inorder(x: Node<K, V>?, lambda: (Node<K, V>) -> Unit) {
        if (x == null) return
        inorder(x.left, lambda)
        lambda(x)
        inorder(x.right, lambda)
    }
}
