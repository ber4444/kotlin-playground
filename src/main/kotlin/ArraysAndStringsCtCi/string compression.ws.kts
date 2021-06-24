package ArraysAndStringsCtCi

// compress a str (composed of a-z, A-Z chrs only) using the count of repeated chrs
fun String.compress(): String {

    if (!this.matches(Regex("[a-zA-Z]+")))
        throw IllegalArgumentException()

    var i = 0
    var count: Int
    val sb = StringBuilder()
    while (i < this.length) {
        count = 1
        while (i != this.length - 1 && this[i + 1] == this[i]) {
            i++
            count++
        }

        sb.append(this[i], count)
        i++
    }

    val result = sb.toString()

    return if (result.length > this.length) this else result
}

"aabccccccccdeFFFFggggggghi".compress() == "a2b1c8d1e1F4g7h1i1"
"aaaaaaaaaa".compress() == "a10"
"pedram".compress() == "pedram"
println(try {
    "aa/bc".compress()
    false
} catch (e: Exception) {
    true
})