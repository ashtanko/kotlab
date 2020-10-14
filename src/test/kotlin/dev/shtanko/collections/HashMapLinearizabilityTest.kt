package dev.shtanko.collections

import org.jetbrains.kotlinx.lincheck.LinChecker
import org.jetbrains.kotlinx.lincheck.annotations.Operation
import org.jetbrains.kotlinx.lincheck.annotations.Param
import org.jetbrains.kotlinx.lincheck.paramgen.IntGen
import org.jetbrains.kotlinx.lincheck.strategy.stress.StressCTest
import org.jetbrains.kotlinx.lincheck.verifier.VerifierState
import org.junit.Test
import java.util.concurrent.ConcurrentHashMap

@StressCTest(minimizeFailedScenario = false)
@Param(name = "key", gen = IntGen::class, conf = "1:5")
class HashMapLinearizabilityTest : VerifierState() {

    private val map: ConcurrentHashMap<Int, Int> = ConcurrentHashMap()

    @Operation
    fun put(@Param(name = "key") key: Int, value: Int): Int? {
        return map.put(key, value)
    }

    @Operation
    operator fun get(@Param(name = "key") key: Int): Int? {
        return map[key]
    }

    @Test
    fun test() {
        LinChecker.check(HashMapLinearizabilityTest::class.java)
    }

    override fun extractState(): Any {
        return map
    }
}
