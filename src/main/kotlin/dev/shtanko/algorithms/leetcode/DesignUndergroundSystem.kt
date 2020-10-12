package dev.shtanko.algorithms.leetcode

internal interface UndergroundSystem {
    fun checkIn(id: Int, stationName: String, t: Int)

    fun checkOut(id: Int, stationName: String, t: Int)

    fun getAverageTime(startStation: String, endStation: String): Double
}

class UndergroundSystemImpl : UndergroundSystem {

    private val checkoutMap = hashMapOf<String, Pair<Int, Int>>() // Route - {TotalTime, Count}
    private val checkInMap = hashMapOf<Int, Pair<String, Int>>() // Uid - {StationName, Time}

    override fun checkIn(id: Int, stationName: String, t: Int) {
        checkInMap[id] = stationName to t
    }

    override fun checkOut(id: Int, stationName: String, t: Int) {
        val checkIn = checkInMap[id]
        val route = checkIn?.first + "_" + stationName
        val totalTime = t - checkIn?.second!!
        val checkout = checkoutMap.getOrDefault(route, 0 to 0)
        checkoutMap[route] = checkout.first + totalTime to checkout.second + 1
    }

    override fun getAverageTime(startStation: String, endStation: String): Double {
        val route = startStation + "_" + endStation
        val checkout = checkoutMap[route]
        return checkout?.first?.toDouble()?.div(checkout.second) ?: 0.0
    }
}
