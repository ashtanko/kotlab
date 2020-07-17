package dev.shtanko.concurrency.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)? = null): Job =
    GlobalScope.launch {

        try {
            val data = CoroutineScope(Dispatchers.IO).async {
                return@async work()
            }.await()

            callback?.let {
                it(data)
            }
        } catch (e: UnknownHostException) {
            e.printStackTrace()
        } catch (e: SocketTimeoutException) {
            e.printStackTrace()
        } catch (e: SSLHandshakeException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
