package dev.shtanko.concurrency.coroutines.future

import java.util.concurrent.CompletableFuture
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun <T> CompletableFuture<T>.await(): T =
    suspendCoroutine<T> { cont: Continuation<T> ->
        whenComplete { result, exception ->
            if (exception == null) {
                // the future has been completed normally
                cont.resume(result)
            } else {
                // the future has completed with an exception
                cont.resumeWithException(exception)
            }
        }
    }
