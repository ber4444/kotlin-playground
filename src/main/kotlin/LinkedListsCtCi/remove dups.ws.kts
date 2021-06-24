package LinkedListsCtCi

import java.util.HashSet

class Node(var data: Int){
	var next: Node? = null
	var previous: Node? = null

	fun getList(): String {
		return if (next != null) {
			data.toString() + "->" + next?.getList()
		} else {
			data.toString()
		}
	}
}

// O(N) time solution for: given an unsorted linked list, remove dupes
// (if no HashSet is allowed, we can do it in O(n^2) time only by using 2 pointers -
//   `curr` which iterates through the list, and `runner` which checks subsequent nodes for dupes)
fun Node.deleteDups() {
	var n: Node? = this
	val set = HashSet<Int>()
	var previous: Node? = null
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

fun init(): Node {
	var first = Node(0)
	val head = first
	var second: Node
	for (i in 1..8) {
		second = Node(i % 2)
		first.next = second
		second.previous = first
		first = second
	}
	return head
}

val head = init()
println(head.getList())
head.deleteDups()
println(head.getList())

