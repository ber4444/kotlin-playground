package LinkedLists

import java.util.HashSet

// given an unsorted linked list, remove dupes
fun Node<Int>.deleteDups() {
	var n: Node<Int>? = this
	val set = HashSet<Int>()
	var previous: Node<Int>? = null
	while (n != null) {
		if (set.contains(n.data) && previous != null) {
			previous.next = n.next
		} else {
			set.add(n.data)
			previous = n
		}
		n = n.next
	}
}

var first = Node(0)
val head = first
var second = first
for (i in 1..8) {
	second = Node(i % 2)
	first.next = second
	second.previous = first
	first = second
}

println(head.getList())
head.deleteDups()
println(head.getList())