package LinkedList

import java.util.Queue
import java.util.LinkedList

// difference between array and linkedlist: in a linkedlist, you cannot access elements by index
// however, adding/removing to the head of a list (queue) is O(1) time, while in an array it would be O(n)
val queue: Queue<String> = LinkedList()

queue.add("apple")
queue.add("banana")

println(queue)
println("first: ${queue.peek()}")
println(queue.contains("apple"))
println(queue.size)
println(queue.isEmpty())

////// difference between array and arraylist: array needs "size" and initial values to be specified upfront
val vector = ArrayList<Int>()
vector.add(0)
vector.add(1)
vector.add(2)
println(vector[2])
val arr = Array(4) { 0 } // or arrayOf(0,0,0,0)
arr[3]

// listOf() creates immutable list
// arrayListOf() creates mutable list
// setOf() creates immutable set
// mutableSetOf()
// mapOf()
// mutableMapOf()
// note: mutable String is the StringBuilder

// from scratch singly linked list:
class LinkyList<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(var element: E, var next: Node<E>?)

    fun getFirst() = head?.element
    fun getLast() = tail?.element

    fun prepend(element: E) {
        val h = head
        val newNode = Node(element, h)
        head = newNode
        if (h == null) {
            tail = newNode
        }
        size++
    }

    fun append(element: E) {
        val t = tail
        val newNode = Node(element, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        size++
    }

    fun deleteWithValue(element: E) {
        head?.let { head ->
            if (head.element == element) {
                this.head = head.next
                return
            }
            var curr = head
            while (curr.next != null) {
                if (curr.next?.element == element) {
                    curr.next = curr.next?.next
                    return
                } else curr.next?.let { curr = it } ?: break
            }
        }
    }
}
val sLL = LinkyList<Char>()
sLL.append('b')
println(sLL.getFirst())
sLL.prepend('a')
sLL.append('c')
println(sLL.getFirst())
println(sLL.getLast())
sLL.deleteWithValue('a')
sLL.deleteWithValue('b')
println(sLL.getFirst())
