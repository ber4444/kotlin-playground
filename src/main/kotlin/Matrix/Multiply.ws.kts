package Matrix

fun multiply(a: Array<DoubleArray>, b: Array<DoubleArray>): Array<DoubleArray> {
    val m1 = a.size
    val n1 = a[0].size
    val m2 = b.size
    val n2 = b[0].size
    if (n1 != m2) throw RuntimeException("Illegal matrix dimensions.")
    val c = Array(m1) { DoubleArray(n2) }
    for (i in 0 until m1)
        for (j in 0 until n2)
            for (k in 0 until n1)
                c[i][j] += a[i][k] * b[k][j]
    return c
}

val matrix = arrayOf(
    doubleArrayOf(1.2, 2.5, 3.4),
    doubleArrayOf(1.2, 4.5, 5.46),
    doubleArrayOf(12.2, 23.5, 3.45)
)

val matrix2 = arrayOf(
    doubleArrayOf(11.22, 223.5, 43.4),
    doubleArrayOf(13.2, 42.5, 53.46),
    doubleArrayOf(124.2, 23.5, 34.45)
)

println(multiply(matrix, matrix2).contentDeepToString())
