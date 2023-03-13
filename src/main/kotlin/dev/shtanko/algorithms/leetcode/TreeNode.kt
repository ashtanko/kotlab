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

package dev.shtanko.algorithms.leetcode

import kotlin.math.ceil
import kotlin.math.floor

data class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

internal fun TreeNode?.clone(): TreeNode? {
    if (this == null) return null
    val node = TreeNode(value)
    node.left = left.clone()
    node.right = right.clone()
    return node
}

/**
 * Print a tree
 */
fun TreeNode.prettyPrinted(): String {
    val lines: MutableList<List<String?>> = ArrayList()
    var level: MutableList<TreeNode?> = ArrayList()
    var next: MutableList<TreeNode?> = ArrayList()
    val sb = StringBuffer()

    level.add(this)
    var nn = 1
    var widest = 0
    while (nn != 0) {
        val line: MutableList<String?> = ArrayList()
        nn = 0
        for (n in level) {
            if (n == null) {
                line.add(null)
                next.add(null)
                next.add(null)
            } else {
                val aa = "${n.value}"
                line.add(aa)
                if (aa.length > widest) widest = aa.length
                next.add(n.left)
                next.add(n.right)
                if (n.left != null) nn++
                if (n.right != null) nn++
            }
        }
        if (widest % 2 == 1) widest++
        lines.add(line)
        val tmp: MutableList<TreeNode?> = level
        level = next
        next = tmp
        next.clear()
    }
    var perpiece = lines[lines.size - 1].size * (widest + 4)
    for (i in lines.indices) {
        val line = lines[i]
        val hpw = floor((perpiece / 2f).toDouble()).toInt() - 1
        if (i > 0) {
            for (j in line.indices) {
                // split node
                var c = ' '
                if (j % 2 == 1) {
                    if (line[j - 1] != null) {
                        c = if (line[j] != null) '┴' else '┘'
                    } else {
                        if (line[j] != null) c = '└'
                    }
                }
                sb.append(c)

                // lines and spaces
                if (line[j] == null) {
                    for (k in 0 until perpiece - 1) {
                        sb.append(" ")
                    }
                } else {
                    for (k in 0 until hpw) {
                        sb.append(if (j % 2 == 0) " " else "─")
                    }
                    sb.append(if (j % 2 == 0) "┌" else "┐")
                    for (k in 0 until hpw) {
                        sb.append(if (j % 2 == 0) "─" else " ")
                    }
                }
            }
            sb.append("\n")
        }

        // print line of numbers
        for (j in line.indices) {
            var f = line[j]
            if (f == null) f = ""
            val gap1 = ceil((perpiece / 2f - f.length / 2f).toDouble()).toInt()
            val gap2 = floor((perpiece / 2f - f.length / 2f).toDouble()).toInt()

            // a number
            for (k in 0 until gap1) {
                sb.append(" ")
            }
            sb.append(f)
            for (k in 0 until gap2) {
                sb.append(" ")
            }
        }
        sb.append("\n")
        perpiece /= 2
    }
    return sb.toString()
}

/**
 * @return left height of the tree
 */
fun TreeNode?.height(): Int {
    return if (this == null) -1 else 1 + this.left.height()
}
