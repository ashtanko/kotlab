package dev.shtanko.patterns.behavioral.mediator

import org.slf4j.LoggerFactory

abstract class PartyMemberBase : PartyMember {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(PartyMemberBase::class.java)
    }

    protected var party: Party? = null

    override fun joinedParty(party: Party) {
        LOGGER.info("$this joins the party")
        this.party = party
    }

    override fun partyAction(action: Action) {
        LOGGER.info("$this ${action.description}")
    }

    override fun act(action: Action) {
        if (party != null) {
            LOGGER.info("$this $action")
            party?.act(this, action)
        }
    }

    abstract override fun toString(): String
}
