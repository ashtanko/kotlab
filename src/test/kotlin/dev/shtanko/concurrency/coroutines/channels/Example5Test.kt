package dev.shtanko.concurrency.coroutines.channels

import junit.framework.Assert.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse

class Example5Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `simple test`() = runBlocking {
        val t1 = newTree(1)
        val t2 = newTree(1)
        val t3 = newTree(2)

        println("t1 = $t1")
        println("t2 = $t2")
        println("t3 = $t3")
        println("t1 same as t2? ${same(t1, t2)}")
        println("t1 same as t3? ${same(t1, t3)}")
        assertTrue(same(t1, t2))
        assertFalse(same(t2, t3))
    }
}
