package DP

// given different coin valuaes (with infinite amount of each), and a given total,
// calculate how many coins we need to pay the total
fun IntArray.coinChange(total: Int): Int {
    val subtotal = IntArray(total+1) { total+1 }
    subtotal[0] = 0
    (1..total).forEach { i ->
        for (coin in this)
            if (i >= coin && subtotal[i - coin] < total + 1) {
                val prev = subtotal[i - coin]
                subtotal[i] = kotlin.math.min(prev + 1, subtotal[i])
            }
    }
    return subtotal.last().let {
        if (it < total+1) it else -1
    }
}

val coins = intArrayOf(25, 10, 5, 1)
println(coins.coinChange(44) == 7)