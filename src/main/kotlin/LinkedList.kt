class Node<T>(var data: T){
    var next: Node<T>? = null
    var previous:Node<T>? = null

    fun getList(): String {
        return if (next != null) {
            data.toString() + "->" + next?.getList()
        } else {
            data.toString()
        }
    }
}

class LinkedList<T> {
    var head: Node<T>? = null

    fun add(value: T) {
        val newNode = Node(value)
        val lastNode = this.last()
        if (lastNode != null) {
            newNode.previous = lastNode
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