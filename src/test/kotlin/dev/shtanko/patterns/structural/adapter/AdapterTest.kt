package dev.shtanko.patterns.structural.adapter

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify

class AdapterTest {

    companion object {
        private const val FISHING_BEAN = "fisher"

        private const val ROWING_BEAN = "captain"
    }

    private val beans: MutableMap<String, Any> by lazy {
        hashMapOf<String, Any>()
    }

    @BeforeEach
    fun setUp() {
        val fishingBoatAdapter = spy(FishingBoatAdapter())
        beans[FISHING_BEAN] = fishingBoatAdapter

        val adapter = beans[FISHING_BEAN] as FishingBoatAdapter
        val captain = Captain(adapter)
        beans[ROWING_BEAN] = captain
    }

    @Test
    fun `simple test`() {
        val captain = beans[ROWING_BEAN] as Captain

        // when captain moves
        captain.row()

        // the captain internally calls the battleship object to move
        val adapter = beans[FISHING_BEAN] as RowingBoat
        verify(adapter).row()
    }
}
