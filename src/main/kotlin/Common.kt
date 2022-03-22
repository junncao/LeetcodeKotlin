data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
 }

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun iterateList(a: ListNode?){
    var b: ListNode? = a
    while (b!=null){
        println(b.`val`)
        b = b.next
    }
}