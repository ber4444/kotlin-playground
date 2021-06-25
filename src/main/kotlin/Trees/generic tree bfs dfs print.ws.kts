package Trees

import java.util.Queue
import java.util.LinkedList

class TreeNode<T>(val value: T) {
    private val children: MutableList<TreeNode<T>> = mutableListOf()

    fun add(child: TreeNode<T>) = children.add(child)

    fun dfs(visit: (TreeNode<T>) -> Unit) {
        visit(this)
        children.forEach {
            it.dfs(visit)
        }
    }

    fun bfs(visit: (TreeNode<T>) -> Unit) {
        visit(this)
        val queue: Queue<TreeNode<T>> = LinkedList()
        children.forEach { queue.add(it) }
        var node = queue.poll()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.add(it) }
            node = queue.poll()
        }
    }

    // modified bfs to print items on the same level of the tree in the same line
    fun printFormatted(visit: (TreeNode<T>) -> Unit) {
        val queue: Queue<TreeNode<T>> = LinkedList()
        var nodesLeftInCurrentLevel = 0
        queue.add(this)
        while (queue.isNotEmpty()) {
            nodesLeftInCurrentLevel = queue.count() // queue is the number of children from the previous iteration
            while (nodesLeftInCurrentLevel > 0) {
                val node = queue.poll()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { queue.add(it) }
                    nodesLeftInCurrentLevel--
                } ?: break
            }
            println()
        }
    }
}

val hot = TreeNode("Hot")
hot.add(TreeNode("tea"))
hot.add(TreeNode("coffee"))
val cold = TreeNode("Cold")
val tree = TreeNode("Beverages").apply {
    add(hot)
    add(cold)
}
tree.dfs { println(it.value) }
println("---")
// print all nodes
tree.printFormatted { println(it.value) }
// search for particular node
tree.bfs { if (it.value=="tea") println("found") }
