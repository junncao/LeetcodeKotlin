import java.util.*

fun main(){
    class Solution {
        fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
            val res: MutableList<List<Int>> = mutableListOf()
            if (root == null) {
                return res
            }
            val q = ArrayDeque<TreeNode>()
            q.add(root)
            // 为 true 时向右，false 时向左
            var flag = true

            // while 循环控制从上向下一层层遍历
            while (!q.isEmpty()) {
                val sz = q.size
                // 记录这一层的节点值
                val level = mutableListOf<Int>()
                // for 循环控制每一层从左向右遍历
                for (i in 0 until sz) {
                    val cur = q.removeFirst()
                    // 实现 z 字形遍历
                    if (flag) {
                        level.add(cur.`val`)
                    } else {
                        level.add(0, cur.`val`)
                    }
                    if (cur.left != null) q.add(cur.left)
                    if (cur.right != null) q.add(cur.right)
                }
                // 切换方向
                flag = !flag
                res.add(level)
            }
            return res
        }
    }
}



class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val sumEndAt = IntArray(nums.size)
        val sumStartAt = IntArray(nums.size)
        sumEndAt[0] = nums[0]
        for (i in 1 until sumEndAt.size){
            if (nums[i] == 1){
                sumEndAt[i] = sumEndAt[i-1]+1
            }else{
                sumEndAt[i] = 0
            }
        }
        sumStartAt[sumStartAt.size-1] = nums[nums.size-1]
        for (i in sumStartAt.size - 2 downTo 0){
            if (nums[i] == 1){
                sumStartAt[i] = sumStartAt[i+1] + 1
            }else{
                sumStartAt[i] = 0
            }
        }

        var ans = 0
        ans = kotlin.math.max(sumStartAt[1], sumEndAt[nums.size -2])
        for (i in 1 until nums.size-1){
            val preSum = sumEndAt[i-1]
            val sufSum = sumStartAt[i+1]
            ans = kotlin.math.max(ans,preSum+sufSum)
        }
        return ans
    }

    fun findPeakElement(nums: IntArray): Int {
        fun firstBigger(pos1: Int, pos2: Int): Boolean{
            return pos2 == -1 || pos2 == nums.size || nums[pos1] > nums[pos2]
        }

        var left = 0
        var right = nums.size - 1
        var ans = -1
        while(left <= right){
            val mid = (left+right)/2
            if (firstBigger(mid, mid+1) && firstBigger(mid,mid-1)){
                ans = mid
                break
            }else if(firstBigger(mid+1, mid)){
                left = mid + 1
            }else{
                right = mid - 1
            }
        }
        return ans
    }

    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var numsSum = 0
        var res = Int.MAX_VALUE
        while (right < nums.size){
            numsSum += nums[right]
            right++
            while (numsSum >= target && left < right){
                res = kotlin.math.min(right - left, res)
                numsSum -= nums[left]
                left++
            }
        }
        return if (res == Int.MAX_VALUE) 0 else res
    }
}