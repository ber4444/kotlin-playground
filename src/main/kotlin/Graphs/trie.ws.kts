package Graphs

// Tries, or prefix trees, are n-ary trees used for storing the words for prefix lookups (kind of like a hashtable that can do partial matches)
// Can check if a string is a valid prefix in O(k) time, where k is the length of the string
class Trie {
    data class Node(var word: String? = null, val childNodes: MutableMap<Char, Node> = mutableMapOf())

    private val root = Node()

    fun insert(word: String) {
        var currentNode = root
        for (char in word) { // we could store the char count to quickly lookup how many words are there for any given prefix
            if (currentNode.childNodes[char] == null) {
                currentNode.childNodes[char] = Node()
            }
            currentNode = currentNode.childNodes[char]!!
        }
        currentNode.word = word
    }

    // further lookups (e.g. user typing subsequent letters of the same word) can be faster if we returned the currentNode
    //  then next lookup would just check if the letter is a child of that node
    fun startsWith(word: String): Boolean {
        var currentNode = root
        for (char in word) {
            if (currentNode.childNodes[char] == null) {
                return false
            }
            currentNode = currentNode.childNodes[char]!!
        }
        return currentNode.word == null
    }

    fun prefixMatch(prefix: String): List<String> {
        var current = root
        for (char in prefix) {
            val child = current.childNodes[char] ?: return emptyList()
            current = child
        }
        return _collections(prefix, current)
    }

    private fun _collections(prefix: String, node: Node?): List<String> {
        val results = mutableListOf<String>()
        if (node?.word != null) {
            results.add(prefix)
        }
        node?.childNodes?.forEach { (key, node) ->
            results.addAll(_collections(prefix + key, node))
        }
        return results
    }
}

val trie = Trie()
listOf(
    "hello",
    "help",
    "helicopter",
    "hero",
    "hope",
    "echo",
    "hotel",
    "hot",
    "hop"
).forEach { trie.insert(it) }
println(trie.startsWith("he"))
println(trie.startsWith("xyz"))
println(trie.prefixMatch("he"))
