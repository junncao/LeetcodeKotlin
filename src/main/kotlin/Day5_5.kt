import java.util.*

class Day5_5 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val dummy = ListNode(-1)
        var p = dummy
        val queue = PriorityQueue<ListNode>(
            lists.size
        ) { o1, o2 ->
            o1.`val` - o2.`val`
        }
        for (head in lists){
            if (head != null){
                queue.add(head)
            }
        }
        while (queue.isNotEmpty()){
            val cur = queue.poll()
            p.next = cur
            if (cur.next != null){
                queue.add(cur.next)
            }
            p = p.next!!
        }
        return dummy.next
    }
}