object Day5_7 {

    val res = mutableListOf<List<Int>>()
    val track = mutableListOf<Int>()
    var trackSum = 0
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        backtrack(candidates, target, 0)
        return res
    }

    fun backtrack(
        candidates: IntArray,
        target: Int,
        start: Int
    ){
        if (trackSum == target){
            res.add(ArrayList(track))
            return
        }
        if (trackSum > target){
            return
        }
        for (i in start until candidates.size){
            if (i > start && candidates[i] == candidates[i-1]){
                continue
            }
            track.add(candidates[i])
            trackSum += candidates[i]
            backtrack(candidates, target, i+1)
            track.removeAt(track.size-1)
            trackSum -= candidates[i]
        }
    }

    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var r_max = 0
        var l_max = 0
        var res = 0
        while(left < right){
            l_max = kotlin.math.max(l_max, height[left])
            r_max = kotlin.math.max(r_max, height[right])
            if(l_max < r_max){
                res += l_max - height[left]
                left++
            }else{
                res += r_max - height[right]
                right++
            }
        }
        return res
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        var a = head
        var b = head
        for(i in 0 until k){
            if (b == null){
                return head
            }
            b = b.next
        }
        //左闭右开
        val newHead = reverseBetween(a, b)
        a.next = reverseKGroup(b, k)
        return newHead
    }

    private fun reverseBetween(a: ListNode?, b: ListNode?): ListNode? {
        var pre:ListNode? = null
        var cur = a
        var next = a
        while (cur !== b){
            next = cur?.next
            cur?.next = pre
            pre = cur
            cur = next
        }
        return pre
    }

}

fun main(){
    val res = Day5_7.reverseKGroup(ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }, 1)
    println(iterateList(res))
}