package DP

// O(2^n) time complexity... space complexity includes the call stack so it is O(n)
tailrec fun fib(x: Int, a: Int = 0, b: Int = 1): Int {
    return if (x == 0) a
    else fib(x-1, b, a+b)
}

// because of "tailrec" the above is rewritten to something like:
fun iterative(n: Int): Int {
    if (n < 2) return n
    var minusOne = 1
    var minusTwo = 0
    var result = minusOne
    for (i in 2..n) {
        result = minusOne + minusTwo
        minusTwo = minusOne
        minusOne = result
    }
    return result
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
println(fib(n))
println(iterative(n))