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

package dev.shtanko.algorithms.leetcode

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

internal abstract class DeepestLeavesSumTest<out T : DeepestLeavesSum>(private val strategy: T) {
    internal class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(4).apply {
                            left = TreeNode(7)
                        }
                        right = TreeNode(5)
                    }
                    right = TreeNode(3).apply {
                        right = TreeNode(6).apply {
                            right = TreeNode(8)
                        }
                    }
                },
                15
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `deepest leaves sum test`(root: TreeNode, expected: Int) {
        val actual = strategy.perform(root)
        assertThat(actual).isEqualTo(expected)
    }
}

internal class DeepestLeavesSumDFSTest : DeepestLeavesSumTest<DeepestLeavesSumDFS>(DeepestLeavesSumDFS())
internal class DeepestLeavesSumBFSTest : DeepestLeavesSumTest<DeepestLeavesSumBFS>(DeepestLeavesSumBFS())
internal class DeepestLeavesSumOptimizedBFSTest :
    DeepestLeavesSumTest<DeepestLeavesSumOptimizedBFS>(DeepestLeavesSumOptimizedBFS())
