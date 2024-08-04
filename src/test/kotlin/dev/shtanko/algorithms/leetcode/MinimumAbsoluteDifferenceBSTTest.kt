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

import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class MinimumAbsoluteDifferenceBSTTest<out T : MinimumAbsoluteDifferenceBST>(private val strategy: T) {
    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                TreeNode(4).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(1)
                        right = TreeNode(3)
                    }
                    right = TreeNode(6)
                },
                1,
            ),
            Arguments.of(
                TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(48).apply {
                        left = TreeNode(12)
                        right = TreeNode(49)
                    }
                },
                1,
            ),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `get minimum difference test`(root: TreeNode, expected: Int) {
        val actual = strategy.getMinimumDifference(root)
        assertThat(actual).isEqualTo(expected)
    }
}

class MinimumAbsoluteDifferenceBSTDFSTest : MinimumAbsoluteDifferenceBSTTest<MinimumAbsoluteDifferenceBST>(
    MinimumAbsoluteDifferenceBSTDFS(),
)

class MinimumAbsoluteDifferenceBSTInOrderTest : MinimumAbsoluteDifferenceBSTTest<MinimumAbsoluteDifferenceBST>(
    MinimumAbsoluteDifferenceBSTInOrder(),
)

class MinimumAbsoluteDifferenceBSTInOrderOptTest : MinimumAbsoluteDifferenceBSTTest<MinimumAbsoluteDifferenceBST>(
    MinimumAbsoluteDifferenceBSTInOrderOpt(),
)
