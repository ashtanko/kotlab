/*
 * Copyright 2023 Oleksii Shtanko
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

/**
 * 894. All Possible Full Binary Trees
 * @see <a href="https://leetcode.com/problems/all-possible-full-binary-trees/">Source</a>
 */
fun interface AllPossibleFullBinaryTrees {
    operator fun invoke(n: Int): List<TreeNode?>
}

class AllPossibleFullBinaryTreesIterative : AllPossibleFullBinaryTrees {
    override fun invoke(n: Int): List<TreeNode?> {
        val ret: MutableList<TreeNode> = ArrayList()
        if (n % 2 == 0) {
            return ret
        } else if (1 == n) {
            ret.add(TreeNode(0))
            return ret
        }

        // Build up a cache of a all possible FBT for the N - 2 levels
        // these levels will be linked together as a graph and should not
        // be returned
        val cache: MutableList<MutableList<TreeNode>> = ArrayList()
        cache.add(ArrayList<TreeNode>())
        cache[0].add(TreeNode(0))
        for (root in 1 until n / 2) {
            val newRoot: MutableList<TreeNode> = ArrayList()
            for (leftSize in 0 until root) {
                for (left in cache[leftSize]) {
                    for (right in cache[root - leftSize - 1]) {
                        val newTree = TreeNode(0)
                        newTree.left = left
                        newTree.right = right
                        newRoot.add(newTree)
                    }
                }
            }
            cache.add(newRoot)
        }

        // Cached values are linked together and must be cloned to be unlinked
        // trees before returning
        for (root in 0 until n / 2) {
            for (left in cache[root]) {
                for (right in cache[n / 2 - root - 1]) {
                    val newTree = TreeNode(0)
                    newTree.left = left.clone()
                    newTree.right = right.clone()
                    ret.add(newTree)
                }
            }
        }

        return ret
    }
}

class AllPossibleFullBinaryTreesRecursive : AllPossibleFullBinaryTrees {
    override fun invoke(n: Int): List<TreeNode?> {
        val ret: MutableList<TreeNode> = ArrayList()
        if (1 == n) {
            ret.add(TreeNode(0))
        } else if (n % 2 != 0) {
            var i = 2
            while (i <= n) {
                val leftBranch = invoke(i - 1)
                val rightBranch = invoke(n - i)
                val leftIter = leftBranch.iterator()
                while (leftIter.hasNext()) {
                    val left = leftIter.next()
                    val rightIter = rightBranch.iterator()
                    while (rightIter.hasNext()) {
                        val right = rightIter.next()
                        val tree = TreeNode(0)

                        // If we're using the last right branch, then this will be the last time this left branch is
                        // used and can hence
                        // be shallow copied, otherwise the tree will have to be cloned
                        tree.left = if (rightIter.hasNext()) left.clone() else left

                        // If we're using the last left branch, then this will be the last time this right branch is
                        // used and can hence
                        // be shallow copied, otherwise the tree will have to be cloned
                        tree.right = if (leftIter.hasNext()) right.clone() else right
                        ret.add(tree)
                    }
                }
                i += 2
            }
        }
        return ret
    }
}
