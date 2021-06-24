package Threads

import java.util.concurrent.atomic.AtomicInteger
import kotlin.concurrent.thread

class Blah {
    var counter: Int = 0
        private set
    fun increment(): Int {
        synchronized(this) {
            counter++
        }
        return counter
    }
}
val shared = Blah()
val shared2 = AtomicInteger(0)

// only one will be able to call blah() because of synchronization, not in parallel
// deadlock: 2 threads are waiting for each other to release a lock
for (i in 1..10) Thread {
    shared2.incrementAndGet()
    shared.increment()
}.start()
println("a $shared2")
println(shared.counter)
for (i in 1..10) thread(start = true) {
    shared2.incrementAndGet()
    shared.increment()
}
println("b $shared2")
println(shared.counter)



