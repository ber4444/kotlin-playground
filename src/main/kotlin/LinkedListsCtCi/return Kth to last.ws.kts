package LinkedListsCtCi

class Node<T>(var data: T){
    var next: Node<T>? = null
}

class LinkedList<T> {
    var head: Node<T>? = null

    fun add(value: T) {
        val newNode = Node(value)
        val lastNode = this.last()
        if (lastNode != null) {
            lastNode.next = newNode
        } else {
            head = newNode
        }
    }

    private fun last(): Node<T>? {
        var node = head
        return if (node != null){
            while (node?.next != null) {
                node = node.next
            }
            node
        } else null
    }
}

// O(n) time, O(1) space solution for:
// find the Nth to last element of a singly linked list (size of list unknown)
// here k=1 is last element, k=2 is 2nd last, etc
// (if the size of the list is known, just iterate to the element at length-k position)
fun Node<Int>.nthToLast(k: Int): Node<Int>? {
    var p1: Node<Int>? = this // will remain k notes apart from p2
    var p2: Node<Int>? = this // will denote the beginning of the list

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
