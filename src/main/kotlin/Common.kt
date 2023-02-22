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

class NodeN(var `val`: Int) {
    var children: List<NodeN?> = listOf()
}

fun TreeNode.print(){
    left?.print()
    println(this.`val`)
    right?.print()
}

fun linkedList(vararg nodes: Int): ListNode {
    if (nodes.isEmpty()){
        throw Exception("list can't be empty!")
    }
    val head = ListNode(nodes.first())
    var cur = head
    for (i in 1 until nodes.size){
        ListNode(nodes[i]).apply {
            cur.next = this
            cur = this
        }
    }
    return head
}

fun ListNode?.print(){
    if (this == null){
        println(null)
        return
    }
    val nodeList = mutableListOf<Int>()
    var cur = this
    while (cur!= null){
        nodeList.add(cur.`val`)
        cur = cur.next
    }
    println(nodeList)
}