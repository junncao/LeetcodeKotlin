object ReverseLinkedList {


    fun reverse(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val last = reverse(head.next)
        head.next!!.next = head
        head.next = null
        return last
    }


    private var successor: ListNode? = null
    fun reverseN(head: ListNode, n: Int): ListNode{
        if(n == 1){
            successor = head.next
            return head
        }
        val last = reverseN(head.next!!, n-1)
        head.next!!.next = head
        head.next = successor
        return last
    }

    fun reverseN1(head: ListNode, n: Int): ListNode {
        var m = n
        var cur = head
        for (i in 0 until n){
            cur = cur.next!!
        }
        val tail = cur
        fun reverse(head: ListNode?): ListNode {
            if (head?.next == tail) return head
            val last = reverse(head!!.next)
            head.next!!.next = head
            head.next = tail
            return last
        }
        return reverse(head)
    }

    fun reverseBetween(head: ListNode, m: Int, n: Int): ListNode{
        if (m == 1){
            return reverseN(head, n)
        }
        head.next = reverseBetween(head.next!!, m-1, n-1)
        return head
    }


}

fun main() {
//    val input = linkedList(1,2,3,4,5,6,7,8,9)
//    val res = ReverseLinkedList.reverseN(input, 5)
//    res.print()
//
//    val input1 = linkedList(1,2,3,4,5,6,7,8,9)
//    val res1 = ReverseLinkedList.reverseBetween(input1, 3, 6)
//    res1.print()
//
//    val input2 = linkedList(1,2,3,4,5,6,7,8,9)
//    val res2 = ReverseLinkedList.reverse(input2)
//    res2.print()

    val input3 = linkedList(1,2,3,4,5,6,7,8,9)
    val res3 = ReverseLinkedList.reverseN1(input3, 5)
    res3.print()


}