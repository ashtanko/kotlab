package dev.shtanko.patterns.behavioral.mediator

import dev.shtanko.patterns.utils.InMemoryAppender
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import java.util.function.Supplier

class PartyMemberTest {

    companion object {
        @JvmStatic
        fun dataProvider(): List<Any> {
            return listOf(
                arrayOf<Supplier<PartyMember>>(Supplier { Hobbit() }),
                arrayOf<Supplier<PartyMember>>(Supplier { Hunter() }),
                arrayOf<Supplier<PartyMember>>(Supplier { Rogue() }),
                arrayOf<Supplier<PartyMember>>(Supplier { Wizard() })
            )
        }
    }

    private lateinit var appender: InMemoryAppender

    @BeforeEach
    fun setUp() {
        appender = InMemoryAppender(PartyMemberBase::class.java)
    }

    @AfterEach
    fun tearDown() {
        appender.stop()
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `party action test`(memberSupplier: Supplier<PartyMember>) {
        val member = memberSupplier.get()
        for (action in Action.values()) {
            member.partyAction(action)
            assertEquals(member.toString() + " " + action.description, appender.lastMessage)
        }
        assertEquals(Action.values().size, appender.logSize)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `act test`(memberSupplier: Supplier<PartyMember>) {
        val member = memberSupplier.get()
        member.act(Action.GOLD)
        assertEquals(0, appender.logSize)

        val party = mock(Party::class.java)
        member.joinedParty(party)
        assertEquals("$member joins the party", appender.lastMessage)

        for (action in Action.values()) {
            member.act(action)
            assertEquals("$member $action", appender.lastMessage)
            verify<Party>(party).act(member, action)
        }

        assertEquals(Action.values().size + 1, appender.logSize)
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    fun `to string test`(memberSupplier: Supplier<PartyMember>) {
        val member = memberSupplier.get()
        val memberClass: Class<out PartyMember?> = member::class.java
        assertEquals(memberClass.simpleName, member.toString())
    }
}