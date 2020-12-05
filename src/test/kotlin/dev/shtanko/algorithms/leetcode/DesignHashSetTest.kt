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
}
