package Matrix

// print a matrix in spiral pattern
// see shorter solutions at https://leetcode.com/problems/spiral-matrix/solution/
fun Array<IntArray>.spiral(): List<Int> {
    if (this.isEmpty() || this[0].isEmpty()) return listOf()
    if (this.size == 1) return this.flatMap { it.toList() }
    if (this[0].size == 1) return this.map { it[0] }
    // get number of elements
    val n = this.size * this[0].size
    val ret = ArrayList<Int>(n)
    val printed = Array(n) { BooleanArray(this[0].size) }
    val middleX = if (this.size % 2 == 0) (this.size - 1) / 2 else this.size / 2
    val middleY = if (this[0].size % 2 == 0) (this[0].size - 1) / 2 else this[0].size / 2
    var row = 0
    var col = 0
    var depth = 0
    while (row <= middleX && col <= middleY && depth <= middleX && depth <= middleY) {
        row = depth
        col = depth
        while (col < this[0].size - depth) {
            if (!printed[row][col]) {
                ret.add(this[row][col])
                printed[row][col] = true
            }
            col++
        }
        col--
        row++
        while (row < this.size - depth) {
            if (!printed[row][col]) {
                ret.add(this[row][col])
                printed[row][col] = true
            }
            row++
        }
        row--
        col--
        while (col >= depth) {
            if (!printed[row][col]) {
                ret.add(this[row][col])
                printed[row][col] = true
            }
            col--
        }
        col++
        row--
        while (row > depth) {
            if (!printed[row][col]) {
                ret.add(this[row][col])
                printed[row][col] = true
            }
            row--
        }
        depth++
    }
    return ret
}

val v = arrayOf(
    intArrayOf(0,1,2,3,4),
    intArrayOf(13,14,15,16,5),
    intArrayOf(12,19,18,17,6),
    intArrayOf(11,10,9,8,7))
println(v.spiral())
val weird = arrayOf(
    intArrayOf(1),
    intArrayOf(2),
    intArrayOf(3)
)
println(weird.spiral())
val weird2 = arrayOf(intArrayOf(4,5,6))
println(weird2.spiral())