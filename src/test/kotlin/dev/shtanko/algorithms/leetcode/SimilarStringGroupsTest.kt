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

import java.util.stream.Stream
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource

abstract class SimilarStringGroupsTest<out T : SimilarStringGroups>(private val strategy: T) {

    private class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(arrayOf(""), 1),
            Arguments.of(arrayOf("a"), 1),
            Arguments.of(arrayOf("one"), 1),
            Arguments.of(arrayOf("tars", "rats", "arts", "star"), 2),
            Arguments.of(arrayOf("omv", "ovm"), 1),
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    internal fun `num similar groups test`(strings: Array<String>, expected: Int) {
        val actual = strategy.numSimilarGroups(strings)
        assertEquals(expected, actual)
    }
}

class SimilarStringGroupsBFSTest : SimilarStringGroupsTest<SimilarStringGroups>(SimilarStringGroupsBFS())
class SimilarStringGroupsDFSTest : SimilarStringGroupsTest<SimilarStringGroups>(SimilarStringGroupsDFS())
class SimilarStringGroupsUnionFindTest : SimilarStringGroupsTest<SimilarStringGroups>(SimilarStringGroupsUnionFind())
class SimilarStringGroupsDSUTest : SimilarStringGroupsTest<SimilarStringGroups>(SimilarStringGroupsDSU())
