package BinaryTrees

import java.util.ArrayDeque
import java.util.Deque

data class Node<T>(val value: T,
                   var leftNode: Node<T>? = null,
                   var rightNode: Node<T>? = null) {
    fun link(left: Node<T>?, right: Node<T>?) = this.apply { linkLeft(left).linkRight(right) }
    private fun linkLeft(left: Node<T>?) = this.apply { leftNode = left }
    private fun linkRight(right: Node<T>?) = this.apply { rightNode = right }
}

fun <T> dfs(root: Node<T>): List<Node<T>> {
    val stack: Deque<Node<T>> = ArrayDeque()
    val traversalList = mutableListOf<Node<T>>()

    stack.push(root)
    // Use stack to create breadth first traversal.
    while (stack.isNotEmpty()) {
        val currentNode = stack.pop()
        currentNode.rightNode?.let { stack.push(it) }
        currentNode.leftNode?.let { stack.push(it) }
        // Add to traversal list.
        traversalList.add(currentNode)
    }
    return traversalList
}

/*
 *        [A]
 *       /   \
 *     [B]    [C]
 *     / \    /  \
 *  [D]  [E] [F] [G]
 *               / \
 *             [H] [I]
 */
val a = Node('a')
val b = Node('b')
val c = Node('c')
val d = Node('d')
val e = Node('e')
val f = Node('f')
val g = Node('g')
val h = Node('h')
val i = Node('i')
a.link(b, c)
b.link(d, e)
c.link(f, g)
g.link(h, i)
println(dfs(a).map { it.value })