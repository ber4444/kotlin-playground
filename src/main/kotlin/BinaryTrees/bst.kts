package BinaryTrees

// a BST is a special binary tree where elements on the left are smaller than ones on the right
// (node: Arrays.binarySearch is in the standard library)
/*
  +------ 5
  |       |
+ 3 +     9
|   |
1   4
we search is top-down and at each level check if the element we wanna find is bigger or smaller than the one we have there
in a balanced BST, both insert() and find() has O(log n) runtime - both of which are O(n) is an unbalanced BST
Traversals:
- inorder: left->root->right
- preorder: root->left->right
- postorder: left->right->root
 */
class Node(
    var value: Int,
    var left: Node? = null,
    var right: Node? = null) {

    fun find(element: Int): Node? = when {
        this.value > element -> left?.find(element)
        this.value < element -> right?.find(element)
        else -> this
    }

    fun insert(element: Int) {
        if (element > this.value)
            if (this.right == null) this.right = Node(element)
            else this.right?.insert(element)
        else if (element < this.value)
            if (this.left == null) this.left = Node(element)
            else this.left?.insert(element)
    }

    fun printInOrder() {
        left?.printInOrder()
        print("$value ")
        right?.printInOrder()
    }
}
// O(1) time, O(log n) space
fun validate(tree: Node?): Boolean {
    return _validate(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}
fun _validate(tree: Node?, min: Int, max: Int): Boolean {
    tree?.let { node ->
        if (node.value < min || node.value > max) return false
        return _validate(node.left, min, node.value-1) && _validate(node.right, node.value+1, max)
    } ?: return true
}
val tree = Node(60) // root
val v = arrayOf(30, 33, 40, 20, 30, 125, 70, 90, 6)
for (e in v) tree.insert(e)
println(tree.find(33) != null)
println(tree.find(34) != null)
println(validate(tree))
tree.printInOrder()
