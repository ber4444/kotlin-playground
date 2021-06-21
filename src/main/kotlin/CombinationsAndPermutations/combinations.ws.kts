package CombinationsAndPermutations

// combinations are different from permutations in that the order of elements matters for the latter only
// in this exercise, return all combinations of k numbers out of 1..n
fun combinations(n: Int, k: Int): List<List<Int>> {
    val ret = mutableListOf<List<Int>>()
    _backtrack(mutableListOf(), k, ret, n, 1)
    return ret
}

fun _backtrack(currentCombination: MutableList<Int>, k: Int, allCombinations: MutableList<List<Int>>, n: Int, index: Int) {
    if (currentCombination.size == k) {
        allCombinations.add(currentCombination.toList())
        return
    }
    for (i in index..n) {
        currentCombination.add(i)
        _backtrack(currentCombination, k, allCombinations, n, index+1)
        currentCombination.removeAt(currentCombination.lastIndex)
    }
}

println(combinations(10,2))