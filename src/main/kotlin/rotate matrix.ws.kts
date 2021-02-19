// rotate NxN matrix by 90 degrees, elements are 4 bytes each
fun Array<IntArray>.rotate(): Array<IntArray> {
	if (this.isEmpty() || this.size != this[0].size) return this // Not a square
	val n = this.size
	for (layer in 0 until n / 2) {
		val last = n - 1 - layer
		for (i in layer until last) {
			val offset = i - layer
			val top = this[layer][i] // save top

			// left -> top
			this[layer][i] = this[last - offset][layer]

			// bottom -> left
			this[last - offset][layer] = this[last][last - offset]

			// right -> bottom
			this[last][last - offset] = this[i][last]

			// top -> right
			this[i][last] = top // right <- saved top
		}
	}
	return this
}

val matrix: Array<IntArray> = arrayOf(intArrayOf(2, 4, 6), intArrayOf(1, 3, 5), intArrayOf(9, 4, 3))
val rotated: Array<IntArray> = arrayOf(intArrayOf(9, 1, 2), intArrayOf(4, 3, 4), intArrayOf(3, 5, 6))

matrix.rotate() contentDeepEquals rotated
