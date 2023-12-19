/*
 * Copyright 2023 Oleksii Shtanko
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.shtanko.algorithms.leetcode

data class NullableListNode(
    var value: Int? = null,
    var next: NullableListNode? = null,
)

fun List<Int>.toNullableListNode(): NullableListNode {
    if (isEmpty()) return NullableListNode()
    var current = NullableListNode()
    var startNode = NullableListNode()
    for (i in indices) {
        val node = NullableListNode(this[i])
        if (i > 0) {
            current.next = node
        } else {
            startNode = node
        }
        current = node
    }
    return startNode
}

fun NullableListNode?.toListOrEmpty(): List<Int> {
    return this?.toList() ?: emptyList()
}

fun NullableListNode.toList(): List<Int> {
    val result = mutableListOf<Int?>()
    var node: NullableListNode? = this
    if (next == null) {
        result.add(value)
        return result.mapNotNull { it }
    }
    while (node != null) {
        result.add(node.value)
        node = node.next
    }
    return result.mapNotNull { it }
}
