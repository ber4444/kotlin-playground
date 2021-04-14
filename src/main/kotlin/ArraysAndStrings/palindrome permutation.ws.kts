package ArraysAndStrings

// O(n) solution to check if a string is a palindrome permutation, n being the length of the input string
// palindrome is the same backwards and forwards (*), permutation is a rearrangement of letters
// (*) meaning all chrs must have an even count, only the middle chr can have an odd count
fun String.isPalindromePerm(): Boolean {

    val strMap = HashMap<Char, Int>()

	// count how many times each chr appears
	this.replace("[^A-Za-z]".toRegex(), "").forEach { strMap[it] = (strMap[it] ?: 0) + 1 }

	// no more than 1 chr should have an odd count
	return strMap.count { it.value.rem(2) == 1 } <= 1
}

"pdepdrremama".isPalindromePerm()
! "pedram".isPalindromePerm()
"pdepdrremama".isPalindromePerm()
! "ped ram".isPalindromePerm()
"pde  pd6rr--emam%a".isPalindromePerm()