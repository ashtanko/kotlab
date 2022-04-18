/*
 * Copyright 2021 Oleksii Shtanko
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

package dev.shtanko.datastructures.tree.btree

import java.util.LinkedList
import java.util.Queue

typealias Visitor<T> = (T) -> Unit

internal class BinaryNode<T>(val value: T) {
    var leftChild: BinaryNode<T>? = null
    var rightChild: BinaryNode<T>? = null

    override fun toString(): String = diagram(this)

    fun traverseInOrder(visit: Visitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    private fun diagram(
        node: BinaryNode<T>?,
        top: String = "",
        root: String = "",
        bottom: String = ""
    ): String {
        return node?.let {
            if (node.leftChild == null && node.rightChild == null) {
                "$root${node.value}\n"
            } else {
                val dr = diagram(
                    node.rightChild,
                    "$top ",
                    "$top┌──",
                    "$top│ "
                )

                val dl = diagram(
                    node.leftChild,
                    "$bottom│ ",
                    "$bottom└──",
                    "$bottom "
                )

                dr.plus(root).plus("${node.value}\n").plus(dl)
            }
        } ?: "${root}null\n"
    }
}

internal fun <T> List<T>.toTree(): BinaryNode<T>? {
    if (isEmpty()) return null
    val root = BinaryNode(first())
    val queue: Queue<BinaryNode<T>> = LinkedList()
    queue.add(root)
    for (i in 1 until this.size) {
        val node = queue.peek()
        if (node.leftChild == null) {
            node.leftChild = BinaryNode(this[i])
            queue.add(node.leftChild)
        } else if (node.rightChild == null) {
            node.rightChild = BinaryNode(this[i])
            queue.add(node.rightChild)
            queue.remove()
        }
    }
    return root
}
