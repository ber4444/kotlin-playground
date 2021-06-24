package ArraysAndStringsCtCi

// O(N) solution for: check if a is substring b with rotation
fun String.isRotation(s: String): Boolean {
	if (this.length == s.length && this.isNotEmpty()) {
		return (this + this).indexOf(s) >= 0
	}
	return false
}

"apple".isRotation("pleap") // ap[pleap]ple
"waterbottle".isRotation("erbottlewat")
! "camera".isRotation("macera")
