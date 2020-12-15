package dev.shtanko.collections

import org.jetbrains.kotlinx.lincheck.LinChecker
import org.jetbrains.kotlinx.lincheck.LoggingLevel
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.annotations.Param
import org.jetbrains.kotlinx.lincheck.paramgen.IntGen
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressCTest
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressOptions
import org.jetbrains.kotlinx.lincheck.verifier.VerifierState
import org.junit.jupiter.api.Test
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap

@StressCTest(minimizeFailedScenario = false)
@Param(name = "key", gen = IntGen::class, conf = "1:5")
internal class HashMapLinearizabilityTest : VerifierState() {

    private val map: ConcurrentMap<Int, Int> = ConcurrentHashMap()

    @Operation
    fun put(@Param(name = "key") key: Int, value: Int): Int? {
        return map.put(key, value)
    }

    @Operation
    operator fun get(@Param(name = "key") key: Int): Int? {
        return map[key]
    }

    @Test
    internal fun test() {
        val opts = StressOptions()
            .iterations(5)
            .threads(3)
            .logLevel(LoggingLevel.INFO)
        LinChecker.check(HashMapLinearizabilityTest::class.java, opts)
    }

    override fun extractState(): Any {
        return map
    }
}
