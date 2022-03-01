import java.util.*
import kotlin.collections.ArrayList

class Day3_1 {
    fun inorderTraversal(root: TreeNode?): List<Int>{
        var pointer = root
        val stack = ArrayDeque<TreeNode>()
        val res = mutableListOf<Int>()
        while (pointer!=null || stack.isNotEmpty()){
            while (pointer!=null){
                stack.push(pointer)
                pointer = pointer.left
            }
            pointer = stack.pop()
            res.add(pointer.`val`)
            pointer = pointer.right
        }
        return res
    }

    fun generateParenthesis(n: Int): List<String>{
        val res = mutableListOf<String>()
        fun backtrack(str: StringBuilder, left: Int, right: Int){
            if (str.length == 2 * n){
                res.add(str.toString())
                return
            }
            if (left < n){
                backtrack(str.append("("), left + 1, right)
                str.deleteCharAt(str.lastIndex) // 每次回溯用的同一个对象，因此要记得这一步
            }
            if (left > right){
                backtrack(str.append(")"), left, right + 1)
                str.deleteCharAt(str.lastIndex)
            }
        }
        backtrack(java.lang.StringBuilder(""), 0, 0)
        return res
    }

    fun permute(nums: IntArray): List<List<Int>>{
        val res = mutableListOf<List<Int>>()
        val visited = IntArray(nums.size)
        fun backtrack(path: ArrayList<Int>){
            if (path.size == nums.size){
                res.add(path.toList())
            }
            for (i in nums.indices){
                if (visited[i] == 1) continue
                visited[i] = 1
                path.add(nums[i])
                backtrack(path)
                visited[i] = 0
                path.removeLast()
            }
        }
        backtrack(ArrayList())
        return res
    }


}
fun main(){
    val solution = Day3_1()
    println(solution.permute(intArrayOf(1,2,3)))
}