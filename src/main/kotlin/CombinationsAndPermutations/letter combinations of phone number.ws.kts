package CombinationsAndPermutations

// return all letter combinations that a digit string could represent on a phone board
fun String.combinations(): List<String> {
    // dictionary that maps digit (array index) to letters
    val dict = arrayOf("0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PRQS", "TUV", "WXYZ")
    val ret = mutableListOf<String>()
    if (this.isEmpty()) return emptyList()
    if (this.length==1) return dict[Integer.valueOf(this)].toCharArray().map { it.toString() }
    val curr = this.substring(1, this.length).combinations()
    val sb = StringBuilder()
    for (chr in dict[Integer.valueOf(this.substring(0,1))].toCharArray())
        for (letter in curr) {
            sb.append(chr.toString()).append(letter)
            ret.add(sb.toString())
            sb.setLength(0)
        }
    return ret
}

println("2".combinations())
println("23".combinations()) // AD AE AF BE ... CF