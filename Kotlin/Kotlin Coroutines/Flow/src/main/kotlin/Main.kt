import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun numbers(): Flow<Int> = flow {
    for (i in 1..5) {
        delay(1000L)
        emit(i)
    }
}

fun main() = runBlocking {
    launch {
        for (k in 1..5) {
            println("I'm not blocked $k")
            delay(1000L)
        }
    }
    numbers().collect { value -> println(value) }
}