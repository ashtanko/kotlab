package dev.shtanko.algorithms.leetcode

import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import org.junit.jupiter.api.Test

internal class PrintInOrderTest {

    private val printInOrder = PrintInOrder()

    @Test
    @Throws(InterruptedException::class)
    internal fun `test print in order with concurrency test`() {
        val service = Executors.newFixedThreadPool(3)
        val latch = CountDownLatch(3)

        service.execute {
            printInOrder.first {
                print("first")
            }
            latch.countDown()
        }

        service.execute {
            printInOrder.second {
                print("second")
            }
            latch.countDown()
        }

        service.execute {
            printInOrder.third {
                print("third")
            }
            latch.countDown()
        }

        latch.await()
    }

    @Test
    @Throws(InterruptedException::class)
    internal fun `test print in order with concurrency 2 test`() {
        val service = Executors.newFixedThreadPool(3)
        val latch = CountDownLatch(3)

        service.execute {
            printInOrder.first {
                print("first")
            }
            latch.countDown()
        }

        service.execute {
            printInOrder.third {
                print("third")
            }
            latch.countDown()
        }

        service.execute {
            printInOrder.second {
                print("second")
            }
            latch.countDown()
        }
        latch.await()
    }
}
