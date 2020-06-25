package dev.shtanko.patterns.structural.adapter

import org.slf4j.LoggerFactory

interface RowingBoat {
    fun row()
}

data class Captain(private val rowingBoat: RowingBoat? = null) {
    fun row() {
        rowingBoat?.row()
    }
}

class FishingBoat {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FishingBoat::class.java)
    }

    fun sail() {
        LOGGER.info("The fishing boat is sailing")
    }
}

class FishingBoatAdapter(private val boat: FishingBoat = FishingBoat()) : RowingBoat {
    override fun row() {
        boat.sail()
    }
}
