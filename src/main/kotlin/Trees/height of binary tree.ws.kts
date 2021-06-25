package Trees

data class Node<T>(val value: T,
                   var leftNode: Node<T>? = null,
                   var rightNode: Node<T>? = null) {
    fun link(left: Node<T>?, right: Node<T>?) = this.apply {
        leftNode = left
        rightNode = right
    }
    // O(n) time - traverses all nodes, and O(n) space because of recursion
    fun height(node: Node<T>? = this): Int = node?.let { 1 + Math.max(height(node.leftNode), height(node.rightNode)) } ?: -1
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
println(a.height().toString())