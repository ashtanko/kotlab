package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal abstract class LFUCacheTest<out T : LFUCache>(private val cache: T) {

    @Test
    fun `LFU cache test`() {
        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1))
        cache.put(3, 3)
        assertEquals(-1, cache.get(2))
        assertEquals(3, cache.get(3))
        cache.put(4, 4)
        assertEquals(-1, cache.get(1))
        assertEquals(3, cache.get(3))
        assertEquals(4, cache.get(4))
    }
}

internal class LFUCacheImplTest : LFUCacheTest<LFUCacheImpl>(LFUCacheImpl(2))
