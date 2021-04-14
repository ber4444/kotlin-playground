package LinkedLists

// partition a linked list so that all nodes < x come before nodes >= x; no need to sort partitions
fun Node<Int>?.partition(x: Int): Node<Int>? {
	var node: Node<Int>? = this
	var head: Node<Int>? = node
	var tail: Node<Int>? = node

	while (node != null) {
		val next: Node<Int>? = node.next
		if (node.data < x) {
			/* Insert node at head. */
			node.next = head
			head = node
		} else {
			/* Insert node at tail. */
			tail?.next = node
			tail = node
		}
		node = next
	}
	tail?.next = null
	return head
}

var ll = LinkedList<Int>()
var vals = intArrayOf(3, 5, 8, 5, 10, 2, 1)
for (i in vals) ll.add(i)

ll.head.partition(5)!!.getList() == "1->2->3->5->8->5->10"