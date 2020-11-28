package dev.shtanko.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import java.util.stream.Stream

abstract class MeetingRoomsTest<out T : MeetingRoomsStrategy>(private val strategy: T) {

    class InputArgumentsProvider : ArgumentsProvider {
        override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> = Stream.of(
            Arguments.of(
                arrayOf(
                    intArrayOf(0, 30),
                    intArrayOf(5, 10),
                    intArrayOf(15, 20)
                ),
                false
            ),
            Arguments.of(
                arrayOf(
                    intArrayOf(7, 10),
                    intArrayOf(2, 4)
                ),
                true
            )
        )
    }

    @ParameterizedTest
    @ArgumentsSource(InputArgumentsProvider::class)
    fun `can attend meetings test`(intervals: Array<IntArray>, expected: Boolean) {
        val actual = strategy.canAttendMeetings(intervals)
        assertEquals(expected, actual)
    }
}

class MeetingRoomsBruteForceTest : MeetingRoomsTest<MeetingRoomsBruteForce>(MeetingRoomsBruteForce())
class MeetingRoomsSortingTest : MeetingRoomsTest<MeetingRoomsSorting>(MeetingRoomsSorting())
