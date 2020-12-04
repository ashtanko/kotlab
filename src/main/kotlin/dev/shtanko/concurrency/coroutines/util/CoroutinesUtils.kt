package dev.shtanko.concurrency.coroutines.util

import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

internal object CoroutinesUtils {

    private const val format = "%s %s %s"
    private const val pattern = "yyyy-MM-dd HH:mm:ss"
    private val currentThreadName = Thread.currentThread().name
    private val currentTime = DateTimeFormatter.ofPattern(pattern).withZone(ZoneOffset.UTC).format(Instant.now())

    fun log(time: String, msg: String): String =
        String.format(
            format,
            time,
            currentThreadName,
            msg
        )

    fun printLog(time: String = currentTime, msg: String) = println(log(time, msg))
}
