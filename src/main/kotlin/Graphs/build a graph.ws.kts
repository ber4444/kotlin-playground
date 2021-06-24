package Graphs

class Graph<T> {
    // maps nodes to adjacent nodes
    private val adjacencyMap = HashMap<T, HashSet<T>>()

    fun addEdge(source: T, dest: T) {
        adjacencyMap.computeIfAbsent(source) { HashSet() }.add(dest)
        // in this case the graph is directed, meaning that a connection is stored both at source and dest
        adjacencyMap.computeIfAbsent(dest) { HashSet() }.add(source)
    }

    override fun toString() = StringBuffer().apply {
        for (key in adjacencyMap.keys) {
            append("$key -> ${adjacencyMap[key]}\n")
        }
    }.toString()
}

/*
visually:
 E
 |
 A - B
which is stored in memory as:
A -> [B, E]
B -> [A]
E -> [A]
(node: if it's an undirected graph, we simply store all connections twice: a->b and b->a)
 */
val graph = Graph<Char>()
graph.addEdge('E', 'A')
graph.addEdge('A', 'B')
graph.addEdge('C', 'D')
println(graph.toString())