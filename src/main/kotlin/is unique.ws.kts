// O(n) solution to check if str has all unique characters
fun isUnique(str: String) = str.length == str.toSet().size

isUnique("")
isUnique("abcd")
! isUnique("test")
! isUnique("estt")