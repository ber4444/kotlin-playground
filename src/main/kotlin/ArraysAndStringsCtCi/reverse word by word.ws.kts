package ArraysAndStringsCtCi

fun String.reverseWords() = this.split(" ").reversed().joinToString(" ")

"hello world!".reverseWords() == "world! hello"