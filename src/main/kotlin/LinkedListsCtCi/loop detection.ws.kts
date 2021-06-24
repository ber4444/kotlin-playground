package LinkedListsCtCi

class Node(var data: Int){
    var next: Node? = null
}

class LinkedList {
    var head: Node? = null

    fun add(newNode: Node) {
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

// e.g. a->b->c->d->c [same c as before]
// detect if it has loop by using a fastRunner (moves 2 steps at a time) and a slowRunner (moves 1 step at a time) and see if they collide
fun isCircular(node: Node): Boolean {
    var slow: Node? = node
    var fast: Node? = node
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow === fast) return true
    }
    return false
}

var ll = LinkedList()
ll.add(Node(1))
ll.add(Node(2))
ll.head?.next = ll.head
println(isCircular(ll.head!!))