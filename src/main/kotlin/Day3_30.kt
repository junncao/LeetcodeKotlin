class Day3_30 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val m = matrix.size
        val n = matrix[0].size
        var left = 0
        var right = m * n - 1
        while (left <= right){
            val mid = left + (right - left)/2
            val i: Int= mid / n
            val j: Int = mid % n
            if (matrix[i][j] == target){
                return true
            }else if (matrix[i][j] > target){
                right = mid - 1
            }else{
                left = mid + 1
            }
        }
        return false
    }

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p?.`val` != q?.`val`) return false
        else if(p == null && q == null) return true
        else return isSameTree(p?.left,q?.left) && isSameTree(p?.right, q?.right)
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        return check(root, root)
    }

    fun check(root1: TreeNode?, root2: TreeNode?): Boolean{
        if (root2 == null && root1 == null) return true
        if (root2 == null || root1 == null) return false
        return root2.`val` == root1.`val` && check(root1.left, root2.right) && check(root1.right, root2.left)
    }

    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()
        var i = 0
        while( i < intervals.size && intervals[i][1] < newInterval[0]){
            res.add(intervals[i])
            i++
        }
        while (i < intervals.size && intervals[i][0] > newInterval[1]){
            newInterval[0] = kotlin.math.min(newInterval[0], intervals[i][0])
            newInterval[1] = kotlin.math.max(newInterval[1], intervals[i][1])
            i++
        }
        res.add(newInterval)
        while (i < intervals.size){
            res.add(intervals[i])
            i++
        }
        return res.toTypedArray()

    }
}

fun main(){
    val s = Day3_30()
    val matrix = arrayOf(intArrayOf(1,1))

    println(s.searchMatrix(matrix, 2))



}