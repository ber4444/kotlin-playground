package Warmup

println((1..100).map { mapOf(
    0 to it,
    it % 3 to "Fizz",
    it % 5 to "Buzz",
    it % 15 to "FizzBuzz"
)[0] })