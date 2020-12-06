package dev.shtanko.collections

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.annotations.Param
import org.jetbrains.kotlinx.lincheck.paramgen.IntGen
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressCTest
import org.jetbrains.kotlinx.lincheck.verifier.VerifierState
import org.jetbrains.kotlinx.lincheck.verifier.linearizability.LinearizabilityVerifier

@Param(name = "value", gen = IntGen::class, conf = "1:5")
@StressCTest(verifier = LinearizabilityVerifier::class, actorsAfter = 0)
class ChanelLinearizabilityTest : VerifierState() {
    private val ch = Channel<Int>(capacity = 3)

    @Operation
    suspend fun send(@Param(name = "value") value: Int) {
        ch.send(value)
    }

    @Operation
    suspend fun receive() = ch.receive()

    // @Test
    // fun `run test`() {
    //     val opts = StressOptions()
    //         .iterations(5)
    //         .logLevel(LoggingLevel.INFO)
    //     LinChecker.check(ChanelLinearizabilityTest::class.java, opts)
    // }

    @Operation
    fun close() = ch.close()

    // state = elements in the channel + closed flag
    @ExperimentalCoroutinesApi
    override fun extractState(): Any {
        val elements = mutableListOf<Int>()
        while (!ch.isEmpty) {
            elements.add(ch.poll()!!)
        }
        val closed = ch.isClosedForSend
        return elements to closed
    }
}
