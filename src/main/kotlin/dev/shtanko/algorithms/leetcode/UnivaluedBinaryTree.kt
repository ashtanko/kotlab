/*
 * Copyright 2020 Oleksii Shtanko
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

fun interface UnivaluedBinaryTreeStrategy {
    operator fun invoke(root: TreeNode?): Boolean
}

class UnivaluedBinaryTreeDFS : UnivaluedBinaryTreeStrategy {

    private var values: MutableList<Int> = mutableListOf()

    override operator fun invoke(root: TreeNode?): Boolean {
        dfs(root)
        for (value in values) {
            if (value != values.first()) return false
        }
        return true
    }

    private fun dfs(node: TreeNode?) {
        if (node != null) {
            values.add(node.value)
            dfs(node.left)
            dfs(node.right)
        }
    }
}

class UnivaluedBinaryTreeRecursive : UnivaluedBinaryTreeStrategy {
    override operator fun invoke(root: TreeNode?): Boolean {
        val isLeftCorrect = root?.left == null || root.value == root.left?.value && invoke(root.left)
        val isRightCorrect = root?.right == null || root.value == root.right?.value && invoke(root.right)
        return isLeftCorrect && isRightCorrect
    }
}
