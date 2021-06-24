package Threads

import java.util.concurrent.atomic.AtomicInteger
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
// I tried to add the dependency via gradle but something is broken

val atomicInteger = AtomicInteger(0)

runBlocking {
    repeat(10) { launch { add() }}
}
suspend fun add() = atomicInteger.incrementAndGet()
println(atomicInteger)
