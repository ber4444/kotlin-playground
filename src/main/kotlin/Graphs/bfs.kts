package Graphs

import java.util.ArrayDeque
import java.util.Deque

class Graph<T> {
    val adjacencyMap: HashMap<T, HashSet<T>> = HashMap()
    fun addEdge(source: T, dest: T) {
        adjacencyMap.computeIfAbsent(source) { HashSet() }.add(dest)
        // in this case the graph is directed, meaning that a connection is stored both at source and dest
        adjacencyMap.computeIfAbsent(dest) { HashSet() }.add(source)
    }
}

// not recursive, just uses a queue and needs a "visited" flag so that we don’t backtrack and revisit nodes
fun <T> bfs(graph: Graph<T>,
            startNode: T): String {
    // Mark all the vertices / nodes as not visited. And keep track of sequence
    // in which nodes are visited, for return value.
    val traversalList = mutableListOf<T>()
    val visitedMap = mutableMapOf<T, Boolean>().apply {
        for (node in graph.adjacencyMap.keys) this[node] = false
    }

    class Queue {
        val queue: Deque<T> = ArrayDeque()
        fun add(node: T) = queue.add(node)
        fun isNotEmpty() = queue.isNotEmpty()
        fun remove() = queue.remove()
    }
    val queue = Queue()
    // Initial step -> add the startNode to the queue.
    queue.add(startNode)
    // Traverse the graph
    while (queue.isNotEmpty()) {
        // Remove the item at the head of the queue.
        val currentNode = queue.remove()
        if (visitedMap[currentNode] == false) {
            // Mark the current node visited and add to traversal list.
            traversalList.add(currentNode)
            visitedMap[currentNode] = true
            // Add nodes in the adjacency map.
            graph.adjacencyMap[currentNode]?.forEach { queue.add(it) }
        }
    }
    return traversalList.toString()
}

val graph = Graph<Char>()
graph.addEdge('E', 'A')
graph.addEdge('A', 'B')
graph.addEdge('A', 'C')
graph.addEdge('C', 'D')
// start with an arbitrary node, and explore each neighbor ("breath first") before moving on to their children - moving level by level
// BFS is typically better than DFS for path finding
// for finding the shortest path, we can run 2 simultaneous BFS and the path is where they collide - it's called bidirectional search
println(bfs(graph, 'E'))