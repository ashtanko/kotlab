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
internal class ChanelLinearizabilityTest : VerifierState() {
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
    internal fun close() = ch.close()

    // state = elements in the channel + closed flag
    @OptIn(ExperimentalCoroutinesApi::class)
    override fun extractState(): Any {
        val elements = mutableListOf<Int>()
        while (!ch.isEmpty) {
            elements.add(ch.tryReceive().getOrNull()!!)
        }
        val closed = ch.isClosedForSend
        return elements to closed
    }
}
