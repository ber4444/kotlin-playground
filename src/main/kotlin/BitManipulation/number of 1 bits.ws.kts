package BitManipulation

// return number of 1 bits a number has (assume it's positive)
// tip: "and" returns 1 is two bits are both one
fun Int.numberOfOnes(): Int {
    var ret = 0
    var x = this
    while(x > 0) {
        ret++
        x = x and x-1
    }
    return ret
}

println(Integer.toBinaryString(11))
println(11.numberOfOnes() == 3)