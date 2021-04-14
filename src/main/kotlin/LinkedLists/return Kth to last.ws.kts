package LinkedLists

// find the Nth to last element of a singly linked list
fun Node<Int>.nthToLast(k: Int): Node<Int>? {
    var p1: Node<Int>? = this
    var p2: Node<Int>? = this

    /* Move p1 k nodes into the list.*/
    for (i in 0 until k) {
        if (p1 == null) return null // Out of bounds
        p1 = p1.next
    }

    /* Move them at the same pace. When p1 hits the end,
		 * p2 will be at the right element. */
    while (p1 != null) {
        p1 = p1.next
        p2 = p2?.next
    }
    return p2
}

var ll = LinkedList<Int>()
for (i in 0..6) ll.add(i)

ll.head?.nthToLast(4)?.data == 3
