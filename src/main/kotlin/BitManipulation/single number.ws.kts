package BitManipulation

// find non-dupe element
// tip: "xor" returns 0 if 2 numbers are the same, otherwise 1
fun IntArray.nonDupe(): Int {
    var x = this[0]
    for (i in 1 until this.size)
        x = x xor this[i]
    return x
}

val v = intArrayOf(2,2,3,4,4,5,5)
println(v.nonDupe() == 3)