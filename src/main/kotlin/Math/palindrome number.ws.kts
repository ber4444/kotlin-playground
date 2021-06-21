package Math

fun Int.palindrome(): Boolean {
    if (this < 0) return false
    if (this % 10 == 0 && this != 0) return false
    var curr = this
    var reversed = 0
    while (curr > reversed) {
        reversed = reversed * 10 + curr % 10
        curr /= 10
    }
    return reversed == curr || reversed / 10 == curr
}

println(1001.palindrome())
println(123.palindrome())