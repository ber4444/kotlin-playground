package ArraysAndStrings

// O(n) solution to check if str has all unique characters
fun String.isUnique() = this.length == this.toSet().size

"".isUnique()
"abcd".isUnique()
! "test".isUnique()
! "estt".isUnique()

// what if we cannot use a Set:
// should clarify if str is ASCII or Unicode - answer: the former, meaning we have 128 chr options
// O(c) space, O(c) time solution, where c is the size of character set
// this may be faster than the above where n was the size of the input string
fun String.isUniqueV2(): Boolean {
	if (this.length > 128) return false // you cannot form a unique str from a larger array of chrs than what's in the alphabet

	val set = BooleanArray(128) // the flag at index i indicates whether chr i in the alphabet is in the str
	for (element in this) {
		val e = element.code
		if (set[e]) return false // already found this chr in the str
		set[e] = true
	}
	return true
}

"".isUniqueV2()
"abcd".isUniqueV2()
! "test".isUniqueV2()
! "estt".isUniqueV2()

// what if you cannot use data structures?
// compare each chr of str1 to each chr of str2, O(n^2) time
