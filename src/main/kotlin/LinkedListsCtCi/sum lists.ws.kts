package LinkedListsCtCi

class Node(var data: Int){
	var next: Node? = null

	fun linkedListToInt(): Int {
		var value = 0
		this.next?.let {
			value = 10 * it.linkedListToInt()
		}
		return value + this.data
	}
}

class LinkedList {
	var head: Node? = null

	fun add(value: Int) {
		val newNode = Node(value)
		val lastNode = this.last()
		if (lastNode != null) {
			lastNode.next = newNode
		} else {
			head = newNode
		}
	}

	private fun last(): Node? {
		var node = head
		return if (node != null){
			while (node?.next != null) {
				node = node.next
			}
			node
		} else null
	}
}

// e.g. 6->1->7 + 2->9->5 = 9->1->2
// (note: head of the 1st list is 7, that us what we add first)
// add node by node and carry the excess
fun Node.addLists(node: Node?, carry: Int = 0): Node? {
	if (node == null && carry == 0) {
		return null
	}
	val result = Node(0)
	var value = carry
	value += this.data
	if (node != null) {
		value += node.data
	}
	result.data = value % 10
	node?.let {
		result.next = this.next?.addLists(it.next, if (value >= 10) 1 else 0)
	}
	return result
}

val ll = LinkedList()
val ll2 = LinkedList()
ll.add(7)
ll.add(1)
ll.add(6)
ll2.add(5)
ll2.add(9)
ll2.add(2)
println(ll.head?.addLists(ll2.head)?.linkedListToInt())