package Math

fun Int.reversed(): Int {
    var ret = 0L // a reversed Int may not fit into an Int
    var n = this
    while (n != 0) {
        val lastDigit = n % 10 // e.g. 15 % 10 will return 5
        n /= 10
        ret = ret * 10 + lastDigit
        if (ret > Int.MAX_VALUE || ret < Int.MIN_VALUE) return 0
    }
    return ret.toInt()
}

println("1234".reversed().toInt() == 1234.reversed())
println(1231232999.reversed() == 0)