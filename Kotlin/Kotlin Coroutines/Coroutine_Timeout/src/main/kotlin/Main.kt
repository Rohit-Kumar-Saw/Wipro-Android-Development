import kotlinx.coroutines.*

suspend fun doSomething() {
    delay(3000L) // simulate a long-running task
}

fun main() = runBlocking {
    try {
        withTimeout(2000L) {
            doSomething()
        }
    } catch (e: TimeoutCancellationException) {
        println("The task exceeded the timeout limit.")
    }
}