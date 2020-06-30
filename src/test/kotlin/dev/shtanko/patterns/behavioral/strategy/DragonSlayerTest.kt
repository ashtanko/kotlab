package dev.shtanko.patterns.behavioral.strategy

import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions

class DragonSlayerTest {

    @Test
    fun `go to battle test`() {
        val strategy = mock(DragonSlayingStrategy::class.java)
        val dragonSlayer = DragonSlayer(strategy)

        dragonSlayer.goToBattle()

        verify(strategy).execute()
        verifyNoMoreInteractions(strategy)
    }

    @Test
    fun `change strategy test`() {
        val initialStrategy = mock(DragonSlayingStrategy::class.java)
        val dragonSlayer = DragonSlayer(initialStrategy)

        dragonSlayer.goToBattle()
        verify(initialStrategy).execute()

        val newStrategy = mock(DragonSlayingStrategy::class.java)
        dragonSlayer.changeStrategy(newStrategy)

        dragonSlayer.goToBattle()
        verify(newStrategy).execute()
        verifyNoMoreInteractions(initialStrategy, newStrategy)
    }
}
