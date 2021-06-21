package BitManipulation

// return AND of all ints in a range
// tip: use shifting
fun solution(a: Int, b: Int): Int {
    var x = a
    var y = b
    var ret = 0
    while (x != y && x > 0) {
        x = x shr 1
        y = y shr 1
        ret++
    }
    return x shl ret
}

println(Integer.toBinaryString(2))
println(Integer.toBinaryString(3))
println(Integer.toBinaryString(4))
println(solution(2,4) == 0)