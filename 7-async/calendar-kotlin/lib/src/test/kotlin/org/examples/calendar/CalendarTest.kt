package org.examples.calendar

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class CalendarTest {
    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    private val singleThreadScope: CoroutineScope = CoroutineScope(newSingleThreadContext("OnlyOneThread"))

    // Even though the sayAfter function is a suspend function, the following calls are executed sequentially.
    // The total time for the test is 3 seconds.
    @Test
    fun `Calling suspending functions sequentially`() {
        runBlocking {
            sayAfter(1000uL, "Alice")
            sayAfter(2000uL, "Bob")
        }
    }

    // If the calls you are making are suspend functions, you can execute multiple calls concurrently
    // on the same thread by using the launch extension function on a coroutine scope. Different
    // blocks of code in different launch blocks will execute concurrently; this works because the
    // thread is not blocked while waiting for the conclusion of the call. The following two calls
    // are launched concurrently and take 1 and 2 seconds respectively to resolve, but the total time
    // for the test is 2 seconds.
    @Test
    fun `Using suspending functions in 1 thread`() {
        runBlocking {
            singleThreadScope.launch {
                sayAfter(1000uL, "Alice")
            }
            singleThreadScope.launch {
                sayAfter(2000uL, "Bob")
            }
            delay(2200)
        }
    }

    // If you need the returned value of the call, you can use the async function. While each call takes 1 second to run,
    // the total time for the test is 1 second.
    @Test
    fun `Using suspending function in async calls in 1 thread`() {
        runBlocking(newSingleThreadContext("test")) {
            val one = async { sayAfter(1000uL, "Alice") }
            val two = async { sayAfter(1000uL, "Bob") }

            val finalMessage = "${one.await()}, ${two.await()}"
            println(finalMessage)
        }
    }
}
