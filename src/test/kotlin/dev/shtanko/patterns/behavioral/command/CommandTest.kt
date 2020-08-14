package dev.shtanko.patterns.behavioral.command

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CommandTest {

    companion object {
        private const val GOBLIN = "Goblin"
    }

    @Test
    fun `command test`() {
        val wizard = Wizard()
        val goblin = Goblin()

        wizard.castSpell(ShrinkSpell(), goblin)
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.VISIBLE)

        wizard.castSpell(InvisibilitySpell(), goblin)
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.INVISIBLE)

        wizard.undoLastSpell()
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.VISIBLE)

        wizard.undoLastSpell()
        verifyGoblin(goblin, GOBLIN, Size.NORMAL, Visibility.VISIBLE)

        wizard.redoLastSpell()
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.VISIBLE)

        wizard.redoLastSpell()
        verifyGoblin(goblin, GOBLIN, Size.SMALL, Visibility.INVISIBLE)
    }

    private fun verifyGoblin(goblin: Goblin, expectedName: String, expectedSize: Size, expectedVisibility: Visibility) {
        assertEquals(expectedName, goblin.toString(), "Goblin's name must be same as expectedName")
        assertEquals(expectedSize, goblin.size, "Goblin's size must be same as expectedSize")
        assertEquals(
            expectedVisibility, goblin.visibility,
            "Goblin's visibility must be same as expectedVisibility"
        )
    }
}
