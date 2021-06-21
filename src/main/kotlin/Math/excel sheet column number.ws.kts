package Math

// A B ... AA AB ...
// given these column titles in Excel, return the column number
// e.g. A -> 1, AA -> 27
fun String.colNum(): Int {
    return this.fold(0) {
        result,
        character -> result * 26 + (character - 'A') + 1
    }
}

println("AA".colNum())