package DP

// O(2^n) time complexity... space complexity includes the call stack so it is O(n)
fun fib(x: Int): Int {
    if (x == 0) return 0
    return if (x == 1) 1
    else fib(x-1) + fib(x-2)
}

// O(n) solution with memoization - stores already computed values (space complexity is O(2n) which is still O(n))
fun fib2(x: Int, memo: Array<Int?>): Int {
    if (x == 0) return 0
    if (x == 1) return 1
    else if (memo[x]==null) {
        memo[x] = fib2(x-1, memo) + fib2(x-2, memo)
    }
    return memo[x]!!
}

val n = 6
println(fib2(n, Array(n+1) { null }))
