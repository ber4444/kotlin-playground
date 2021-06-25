package Trees

import java.util.LinkedList

data class Node<T>(val value: T,
                   var leftNode: Node<T>? = null,
                   var rightNode: Node<T>? = null) {
    fun link(left: Node<T>?, right: Node<T>?) = this.apply { linkLeft(left).linkRight(right) }
    private fun linkLeft(left: Node<T>?) = this.apply { leftNode = left }
    private fun linkRight(right: Node<T>?) = this.apply { rightNode = right }
}

// traverses the tree level by level
// due to the nature of a binary tree, there is no need to track whether or not a node is visited
fun <T> bfs(root: Node<T>): List<Node<T>> {
    val queue = LinkedList<Node<T>>()
    val traversalList = mutableListOf<Node<T>>()

    queue.add(root)
    // Use queue to create breadth first traversal.
    while (queue.isNotEmpty()) {
        val currentNode = queue.poll()
        // Add left node first.
        currentNode.leftNode?.let { queue.add(it) }
        // Add right node next.
        currentNode.rightNode?.let { queue.add(it) }
        // Add the node to the traversal list.
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
println(bfs(a).map { it.value })