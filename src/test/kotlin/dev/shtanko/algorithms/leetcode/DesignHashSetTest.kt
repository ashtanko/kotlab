/*
 * Copyright 2020 Alexey Shtanko
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

import org.junit.Assert.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class DesignHashSetTest {

    @Test
    internal fun `hash set test`() {
        val hashSet: DesignHashSet = DesignHashSetImpl()
        hashSet.add(1)
        hashSet.add(2)
        assertTrue(hashSet.contains(1))
        assertFalse(hashSet.contains(3))
        hashSet.add(2)
        assertTrue(hashSet.contains(2))
        hashSet.remove(2)
        assertFalse(hashSet.contains(2))
    }

    @Test
    internal fun `hash set rehash test`() {
        val hashSet: DesignHashSet = DesignHashSetImpl()
        val n = 32 * 3
        for (i in 0 until n) {
            hashSet.add(i)
        }
        assertTrue(hashSet.contains(n - 1))
    }
}
