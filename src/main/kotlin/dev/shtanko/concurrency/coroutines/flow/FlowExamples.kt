package dev.shtanko.concurrency.coroutines.flow

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flow

@InternalCoroutinesApi
class FlowExamples {
    fun simple(): Sequence<Int> = sequence { // sequence builder
        flow {
            emit(3)
        }.conflate()
    }
}
