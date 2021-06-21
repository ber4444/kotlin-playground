package Matrix

// given 2d matrix, if an element is 0, set the entire row and column to all 0
// must do it in place
fun Array<IntArray>.setZeros() {
    val rows = this.size
    val cols = this[0].size
    var isCol = false
    for (row in 0 until rows) {
        if (this[row][0] == 0) isCol = true
        for (col in 1 until cols)
            // instead of setting each row/column element to 0, we just set the first element which
            //   essentially will be an indicator which is then later used to update the matrix)
            if (this[row][col] == 0) {
                this[row][0] = 0
                this[0][col] = 0
            }
    }
    // update based on the indicator
    for (row in 1 until rows)
        for (col in 1 until cols)
            if (this[row][0] == 0 || this[0][col] == 0)
                this[row][col] = 0
    // see if the first row and column needs to be set to zero as well
    if (this[0][0] == 0) for (col in 0 until cols) this[0][col] = 0
    if (isCol) for (row in 0 until rows) this[row][0] = 0
}

val v = arrayOf(
    intArrayOf(1,1,1,1),
    intArrayOf(1,0,1,1),
    intArrayOf(1,1,0,1),
    intArrayOf(0,0,0,1))
v.setZeros()
println(v.map { it.toList() })