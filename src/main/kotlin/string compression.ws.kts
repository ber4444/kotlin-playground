// compress a str (composed of a-z, A-Z chrs only) using the count of repeated chrs
fun String.compress(): String {

    if (!this.matches(Regex("[a-zA-Z]+")))
        throw IllegalArgumentException()

    var idx = 0
    var count: Int
    var currentChar: Char
    val sb = StringBuilder()
    while (idx < this.length) {
        currentChar = this[idx]

        count = 1
        while (idx != this.length - 1 && this[idx + 1] == currentChar) {
            idx++
            count++
        }

        sb.append(currentChar, count)
        idx++
    }

    val result = sb.toString()

    return if (result.length > this.length) this else result
}

"aabccccccccdeFFFFggggggghi".compress() == "a2b1c8d1e1F4g7h1i1"
"aaaaaaaaaa".compress() == "a10"
"pedram".compress() == "pedram"
try {
    "aa/bc".compress()
    false
} catch (e: Exception) {
    true
}