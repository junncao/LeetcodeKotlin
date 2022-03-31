import com.sun.source.tree.Tree

data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
 }

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}
fun iterateList(a: ListNode?){
    var b: ListNode? = a
    while (b!=null){
        println(b.`val`)
        b = b.next
    }
}

fun TreeNode.print(){
    left?.print()
    println(this.`val`)
    right?.print()
}