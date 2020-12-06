package dev.shtanko.concurrency.coroutines.util

import dev.shtanko.concurrency.coroutines.util.CoroutinesUtils.log
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UtilTest {

    @Test
    fun `log test`() = runBlocking {
        val currentThreadName = Thread.currentThread().name
        val msg = "test meessage"

        val currentTime =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC).format(Instant.now())
        val expected = "$currentTime $currentThreadName $msg"
        val actual = log(currentTime, msg)
        assertEquals(expected, actual)
    }
}
