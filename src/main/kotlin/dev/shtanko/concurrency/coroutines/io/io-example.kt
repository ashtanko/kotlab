package dev.shtanko.concurrency.coroutines.io

import dev.shtanko.concurrency.coroutines.run.launch
import dev.shtanko.concurrency.coroutines.context.Swing
import dev.shtanko.concurrency.coroutines.util.log
import java.nio.ByteBuffer
import java.nio.channels.AsynchronousFileChannel
import java.nio.file.Paths

private const val BUFFER_SIZE = 4096
private const val NEW_SIZE = 11

fun main() {
    launch(Swing) {
        val fileName = "/Users/alexey/Dev/KotlinAlgorithms/src/main/kotlin/dev/shtanko/concurrency/coroutines/io/io.kt"
        log("Asynchronously loading file \"$fileName\" ...")
        val channel = AsynchronousFileChannel.open(Paths.get(fileName))
        channel.use { channel ->
            val buf = ByteBuffer.allocate(BUFFER_SIZE)
            val bytesRead = channel.aRead(buf)
            log("Read $bytesRead bytes starting with \"${String(buf.array().copyOf(NEW_SIZE))}\"")
        }
    }
}
