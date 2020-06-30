package dev.shtanko.patterns.behavioral.strategy

import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class DragonSlayingStrategyTest {

    companion object {
        @JvmStatic
        fun dataProvider() = listOf(
            Arguments.of(MeleeStrategy(), "With your Excalibur you sever the dragon's head!"),
            Arguments.of(
                ProjectileStrategy(),
                "You shoot the dragon with the magical crossbow and it falls dead on the ground!"
            ),
            Arguments.of(
                SpellStrategy(),
                "You cast the spell of disintegration and the dragon vaporizes in a pile of dust!"
            )
        )
    }

    private lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender()
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
    }

    /**
     * Test if executing the strategy gives the correct response.
     */
    @ParameterizedTest
    @MethodSource("dataProvider")
    fun testExecute(strategy: DragonSlayingStrategy, expectedResult: String) {
        strategy.execute()
        assertEquals(expectedResult, appender.lastMessage)
        assertEquals(1, appender.logSize)
    }
}
