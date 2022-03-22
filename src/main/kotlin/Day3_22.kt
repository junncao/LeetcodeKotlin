import com.sun.source.tree.Tree
import java.lang.Integer.max
import java.time.chrono.ThaiBuddhistEra

class Day3_22 {

    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s){
            when(c){
                in setOf<Char>('(', '[', '{') -> stack.addLast(c)
                else -> {
                    if (stack.isEmpty() || !isSymmetric(stack.removeLast(), c)){
                        return false
                    }
                }
            }
        }
        return stack.isEmpty()
    }
    fun isSymmetric(a: Char, b: Char): Boolean{
        val map = mapOf<Char, Char>(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )
        return b == map[a]
    }


    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var curArea = 0
        while (left < right){
            if (height[left] <= height[right]){
                curArea = max(height[left] * (right - left), curArea)
                left++
            }else{
                curArea = max(height[right] * (right - left), curArea)
                right --
            }
        }
        return curArea

    }
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        val dummy = ListNode(-1)
        var p = dummy
        while (l1 != null && l2 != null){
            if (l1.`val` <= l2.`val`){
                p.next = l1
                l1 = l1.next
                p = p.next!!
            }else{
                p.next = l2
                l2 = l2.next
                p = p.next!!
            }
        }
        if (l1 != null){
            p.next = l1
        }
        if (l2 != null){
            p.next = l2
        }
        return dummy.next
    }

    fun generateParenthesis(n: Int): List<String> {
        val res = mutableListOf<String>()
        fun backtrack(path: String, left: Int, right: Int){
            if (path.length == 2 * n){
                res.add(path)
                return
            }
            if (left < n){
                backtrack(path+"(", left+1, right)
            }
            if (right < left){
                backtrack(path+")", left, right+1)
            }
        }
        backtrack("", 0, 0)
        return res
    }


    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(-1)
        dummy.next = head
        var p = dummy
        while (p.next != null && p.next!!.next != null){
            val firstNode = p.next
            val secondNode = firstNode!!.next
            val afterSecond = secondNode!!.next
            p.next = p.next!!.next
            p.next!!.next = firstNode
            firstNode.next = afterSecond
            p = p.next!!.next!!
        }
        return dummy.next
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var res = 0
        for (i in grid.indices){
            for (j in grid[0].indices){
                if (grid[i][j] == '1'){
                    res++
                    dfsIsland(grid, i, j)
                }
            }
        }
        return res
    }

    fun dfsIsland(grid: Array<CharArray>, i: Int, j:Int){
        if ( i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || grid[i][j] == '0' ){
            return
        }
        val dirs = arrayOf(intArrayOf(0,1), intArrayOf(0,-1), intArrayOf(1, 0), intArrayOf(-1, 0))
        grid[i][j] = '0'
        for (dir in dirs){
            val k = i + dir[0]
            val l = j + dir[1]
            dfsIsland(grid, k, l)
        }
    }

    fun minDepth(root: TreeNode?): Int {
        if (root == null ) return 0
        var depth = 1
        var queue = ArrayDeque<TreeNode>()
        queue.addLast(root)
        while (queue.isNotEmpty()){
            val children = ArrayDeque<TreeNode>()
            for (node in queue){
                if (node.left == null && node.right == null){
                    return depth
                }
                if (node.left!=null){
                    children.addLast(node.left!!)
                }
                if (node.right != null){
                    children.addLast(node.right!!)
                }
            }
            queue = children
            depth++
        }
        return depth
    }

}
fun main(){
    val solution = Day3_22()
//    val l1 = ListNode(1).apply {
//        next = ListNode(3).apply {
//            next = ListNode(5).apply {
//                next = ListNode(9)
//            }
//        }
//    }

//    val l2 = ListNode(2).apply {
//        next = ListNode(4).apply {
//            next = ListNode(6)
//        }
//    }
//    val b = Day3_22().mergeTwoLists(
//        l1, l2
//    )
//    iterateList(b)

//    val c = solution.swapPairs(l1)
//    iterateList(c)

//    val grid = arrayOf(
//        charArrayOf('1','1','0','0','0'),
//        charArrayOf('1','1','0','0','0'),
//        charArrayOf('0','0','1','0','0'),
//        charArrayOf('0','0','0','1','1')
//    )
//    println(solution.numIslands(grid))
//
    val t = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }
    println(solution.minDepth(t))
}