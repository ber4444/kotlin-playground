package ArraysAndStrings

// O(N) solution for: check if a is substring b with rotation
fun String.isRotation(s: String): Boolean {
	if (this.length == s.length && this.isNotEmpty()) {
		return (this + this).isSubstring(s)
	}
	return false
}

fun String.isSubstring(small: String) = this.indexOf(small) >= 0

"apple".isRotation("pleap")
"waterbottle".isRotation("erbottlewat")
! "camera".isRotation("macera")
