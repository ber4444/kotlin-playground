package ArraysAndStrings

import java.util.*

// assume the array is unsorted
fun IntArray.findKthLargest(k: Int): Int {
    Arrays.sort(this)
    return this[this.size-k]
}

intArrayOf(2,3,1,4,5).findKthLargest(2)