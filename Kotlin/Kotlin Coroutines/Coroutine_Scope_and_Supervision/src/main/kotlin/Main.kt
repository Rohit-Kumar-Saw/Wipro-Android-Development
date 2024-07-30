import kotlinx.coroutines.*

suspend fun doSomething() {
    delay(1000L)
    throw Exception("Something went wrong.")
}

fun main() = runBlocking {
    val supervisor = SupervisorJob()
    with(CoroutineScope(coroutineContext + supervisor)) {
        val child1 = launch {
            doSomething()
        }
        val child2 = launch {
            delay(2000L)
            println("Coroutine 2 completed.")
        }
    }
    delay(3000L)
}