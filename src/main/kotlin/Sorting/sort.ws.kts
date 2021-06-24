package Sorting

// (note: Arrays.sort is in the standard library, and Lists have a .sorted() extension - or can call sort() on a mutable list)
//  merge sort - O(n log n) for all cases (which is slower than O(n))
// down side is that merging the arrays needs O(n) space
// node: Collections.sort uses merge sort, while Arrays.sort uses quick sort (the latter is also O(n log n) but has worse case of O(n^2))
// using a Heap [tree] data structure is also O(n log n)

// a and b and the starting and ending indexes
fun IntArray.sort(a: Int, b: Int): IntArray {
    if (a < b) {
        val middle = (a+b)/2
        this.sort(a, middle) // sort left
        this.sort(middle+1, b) // sort right
        this._merge(a, middle, b) // merge them back together
    }
    return this
}

fun IntArray._merge(a: Int, middle: Int, b: Int) {
    val left = this.copyOfRange(a, middle+1)
    val right = this.copyOfRange(middle+1, b+1)
    var leftIndex = 0
    var rightIndex = 0
    for (i in a..b) {
        if (leftIndex <= left.size-1 && (rightIndex>=right.size || left[leftIndex]<=right[rightIndex])) {
            this[i] = left[leftIndex]
            leftIndex++
        } else {
            this[i] = right[rightIndex]
            rightIndex++
        }
    }
}

val v = intArrayOf(13,14,15,16,5)
v.sort(0,v.size-1)
for (element in v) print("$element ")