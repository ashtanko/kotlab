package dev.shtanko.algorithms.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

internal class MeasureTimeTest {

    @ExperimentalTime
    @Test
    fun `simple test`() {
        val time = measureTime(DurationUnit.MILLISECONDS) {
            repeat(10_000_000) {}
        }
        assertThat(time).isLessThan(250)
    }
}
