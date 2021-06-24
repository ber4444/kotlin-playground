package StacksAndQueuesCtCi

class Stack<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(var prev: Node<E>?, var element: E, var next: Node<E>?)

    fun push(element: E) {
        val t = tail
        val newNode = Node(t, element, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        size++
    }

    fun pop(): E {
        tail?.let {
            val prev = it.prev
            it.prev = null
            tail = prev
            if (prev == null) {
                head = null
            } else {
                prev.next = null
            }
            size--
            return it.element
        } ?: throw StackUnderflowException()
    }

    fun peek(): E {
        tail?.let {
            return it.element
        } ?: throw StackUnderflowException()
    }

    fun isEmpty() = size == 0
}
class StackUnderflowException : RuntimeException()

val stack = Stack<Int>()
stack.push(1)
stack.push(2)
println(stack.peek())
println(stack.pop())
println(stack.peek())
println(stack.isEmpty())
