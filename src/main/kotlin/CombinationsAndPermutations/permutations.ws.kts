package CombinationsAndPermutations

// print all permutations of a string - O(n!) = n x (n-1) x ... x 1
// tip: use backtracking
fun MutableList<Char>.permutations(): List<String> {
    val ret = mutableListOf<String>()
    this._backtrack(0, ret)
    return ret
}

fun MutableList<Char>._backtrack(start: Int, perms: MutableList<String>) {
    if (start == this.size) perms.add(this.toCharArray().concatToString())
    else {
        for (i in start until this.size) {
            this._swap(start, i)
            this._backtrack(start+1, perms)
            this._swap(start, i)
        }
    }
}

fun MutableList<Char>._swap(start: Int, next: Int) {
    val tmp = this[start]
    this[start] = this[next]
    this[next] = tmp
}

println("123".toCharArray().toMutableList().permutations())