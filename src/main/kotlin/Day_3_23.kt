import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.roundToInt

class Day_3_23 {
    // search in a rotated array
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while(left <= right){
            val mid = left + (right - left)/2
            if(target == nums[mid]){
                return mid
            }
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1
                }else{
                    left = mid + 1
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1
                }else{
                    right = mid - 1
                }
            }
        }
        return -1
    }

    //search left bound and right bound
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val leftBound = searchLeftBound(nums, target)
        val rightBound = searchRightBound(nums, target)
        if(leftBound <= rightBound){
            return intArrayOf(leftBound, rightBound)
        }else{
            return intArrayOf(-1, -1)
        }
    }
    private fun searchLeftBound(nums: IntArray, target: Int): Int{
        var left = 0
        var right = nums.size - 1
        while(left <= right){
            val mid = left + (right - left)/2
            if(target > nums[mid]){
                left = mid + 1
            }else{
                right = mid - 1
            }

        }
        return left

    }
    private fun searchRightBound(nums: IntArray, target: Int): Int{
        var left = 0
        var right = nums.size - 1
        while(left <= right){
            val mid = left + (right - left)/2
            if(target >= nums[mid]){
                left = mid + 1
            }else{
                right = mid - 1
            }
        }
        return right
    }

    //lt 39
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        combinationSumBacktrack(
            candidates,
            res,
            ArrayList(),
            target,
            0
        )
        return res
    }
    fun combinationSumBacktrack(
        candidates: IntArray,
        allList: ArrayList<List<Int>>,
        tempList: ArrayList<Int>,
        remain: Int,
        start: Int
    ){
        if (remain < 0){
            return
        }else if (remain == 0){
            allList.add(ArrayList(tempList))
        }else{
            for (i in start until candidates.size) {
                tempList.add(candidates[i])
                combinationSumBacktrack(candidates, allList, tempList, remain - candidates[i], i) // not i + 1 because we can reuse same elements
                tempList.removeAt(tempList.size - 1)
            }
        }
    }


    fun permute(nums: IntArray): List<List<Int>> {
        val track = ArrayList<Int>()
        val res = ArrayList<List<Int>>()
        fun permuteBacktrack(){
            if (track.size == nums.size){
                res.add(ArrayList(track))
                return
            }
            for (i in nums.indices){
                if (track.contains(nums[i])){
                    continue
                }else{
                    track.add(nums[i])
                    permuteBacktrack()
                    track.removeLast()
                }
            }
        }
        permuteBacktrack()
        return res
    }


    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val track = ArrayList<Int>()
        val res = ArrayList<List<Int>>()
        val visited = BooleanArray(nums.size) { false }
        fun permuteBacktrack(){
            if (track.size == nums.size){
                res.add(ArrayList(track))
                return
            }
            for (i in nums.indices){
                //when a number has the same value with its previous, we can use this number only if his previous is used
                if (visited[i] || (i > 0 && nums[i-1] == nums[i] && !visited[i-1])){
                    continue
                }else{
                    visited[i] = true
                    track.add(nums[i])
                    permuteBacktrack()
                    track.removeLast()
                    visited[i] = false
                }
            }
        }
        Arrays.sort(nums)
        permuteBacktrack()
        return res
    }

    fun uniquePaths(m: Int, n: Int): Int {
        var bottom = m + n -2
        var up = kotlin.math.min(m-1, n-1)
        var res: Double = 1.0
        while (up > 0){
            res *= bottom
            res /= up
            bottom--
            up--
        }
        return kotlin.math.round(res).toInt()
    }
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var pointer = 0
        for (i in 1 until nums.size ){
            if (nums[pointer] != nums[i]){
                pointer += 1
                nums[pointer] = nums[i]
            }
        }
        return pointer + 1
    }
}
fun main(){
//    println(Day_3_23().permuteUnique(intArrayOf(1,2,2,3)))
    println(Day_3_23().uniquePaths(4, 6))
    println(Day_3_23().removeDuplicates(intArrayOf(1,2,2,3,3,4,5,5)))

}