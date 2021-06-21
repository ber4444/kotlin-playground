package DP

// find subarray with largest sum, return the sum
fun IntArray.maxSumSubarray(): Int {
    var resultantMax = this[0]
    var currentMax = this[0]
    for (i in 1 until this.size) {
        currentMax = maxOf(this[i], currentMax + this[i])
        resultantMax = maxOf(resultantMax, currentMax)
    }
    return resultantMax
}

val v = intArrayOf(5, 2, -1, 3, -4, -2)
println(v.maxSumSubarray() == 9)