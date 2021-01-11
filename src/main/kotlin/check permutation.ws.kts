// O(n) solution to check if str1 is permutation of str2
fun checkPerm(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false
    val str1Map = strToCountHashMap(str1)
    val str2Map = strToCountHashMap(str2)
    return str1Map == str2Map
}

fun strToCountHashMap(str: String): HashMap<Char, Int> {
    val map: HashMap<Char, Int> = HashMap()
    str.forEach { map[it] = (map[it] ?: 0) + 1 }
    return map
}

checkPerm("", "")
! checkPerm("a", "aa")
checkPerm("pedram", "adepmr")
! checkPerm("pEdram", "adepmr")
! checkPerm("pedram", "pedaam")
! checkPerm("pedram", "pedram ")