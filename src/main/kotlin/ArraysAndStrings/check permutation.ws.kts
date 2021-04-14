package ArraysAndStrings

import java.util.*

// O(n) solution to check if str1 is permutation of str2
// clarify is the permutation comparison is case sensitive, and if white space counts - answers: yes to both
fun String.checkPerm(t: String): Boolean {
	// permutation would imply having the same chrs in different orders so can sort and compare
	return sort(this) == sort(t)
}

fun sort(s: String): String {
	val content = s.toCharArray()
	Arrays.sort(content)
	return String(content)
}

"".checkPerm("")
! "a".checkPerm("aa")
"pedram".checkPerm("adepmr")
! "pEdram".checkPerm("adepmr")
! "pedram".checkPerm("pedaam")
! "pedram".checkPerm("pedram ")