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

// this one uses a Stack
// almost the same as BF traversal except that here a Queue is used instead of a Stack
// (the Deque interface supports both Stack and Queue data types)
fun <T> dfs(graph: Graph<T>, startNode: T): String {
    // Mark all the vertices / nodes as not visited.
    val visitedMap = mutableMapOf<T, Boolean>().apply {
        graph.adjacencyMap.keys.forEach { node -> put(node, false) }
    }
    val stack: Deque<T> = ArrayDeque() // ArrayDeque is a better version of LinkedList
    // Initial step -> add the startNode to the stack.
    stack.push(startNode)
    // Store the sequence in which nodes are visited, for return value.
    val traversalList = mutableListOf<T>()
    // Traverse the graph.
    while (stack.isNotEmpty()) {
        // Pop the node off the top of the stack.
        val currentNode = stack.pop()
        if (visitedMap[currentNode] == false) {
            // Store this for the result.
            traversalList.add(currentNode)
            // Mark the current node visited and add to the traversal list.
            visitedMap[currentNode] = true
            // Add nodes in the adjacency map.
            graph.adjacencyMap[currentNode]?.forEach { stack.push(it) }
        }
    }
    return traversalList.joinToString()
}

val graph = Graph<Char>()
graph.addEdge('E', 'A')
graph.addEdge('A', 'B')
graph.addEdge('A', 'C')
graph.addEdge('C', 'D')
println(dfs(graph, 'E'))