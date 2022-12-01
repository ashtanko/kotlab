/*
 * Copyright 2022 Oleksii Shtanko
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

package dev.shtanko.datastructures.caches

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LRUCacheTest {

    companion object {
        private const val CAP = 5
    }

    @Test
    fun `zero capacity, should throw `() {
        assertThrows<IllegalArgumentException> {
            val lruCache = LRUCache<Int, Int>()
            lruCache.setCapacity(0)
        }
    }

    @Test
    fun `null keys and values`() {
        val mruCache = LRUCache<Int?, Int?>(CAP)
        mruCache[null] = 2
        mruCache[6] = null
        assertThat(mruCache[null]).isEqualTo(2)
        assertThat(mruCache[6]).isNull()
    }

    @Test
    fun `put and get integer values`() {
        val lruCache = LRUCache<Int, Int>(CAP)
        for (i in 0 until CAP) {
            lruCache[i] = i
        }

        for (i in 0 until CAP) {
            assertThat(lruCache[i]).isEqualTo(i)
        }
    }

    @Test
    fun `put and get string values`() {
        val lruCache = LRUCache<String, String>(CAP)
        for (i in 0 until CAP) {
            lruCache["key $i"] = "value $i"
        }

        for (i in 0 until CAP) {
            assertThat(lruCache["key $i"]).isEqualTo("value $i")
        }
    }
}
