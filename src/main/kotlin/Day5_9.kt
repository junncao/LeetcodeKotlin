
object Day5_9 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        if(matrix.isEmpty()) return 0
        val row = matrix.size
        val col = matrix[0].size
        var res = 0
        val dp = Array(row+1){
            IntArray(col+1){
                0
            }
        }
        for (i in 1 until row+1){
            for (j in 1 until col+1){
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = kotlin.math.min(kotlin.math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1
                    res = kotlin.math.max(dp[i][j], res)
                }
            }
        }
        return res * res
    }

    fun twoSum(nums: IntArray, target: Int, start: Int):List<MutableList<Int>> {
        nums.sort()
        var left = start
        var right = nums.size - 1
        val res = mutableListOf<MutableList<Int>>()
        while (left < right){
            val curSum = nums[left] + nums[right]
            if (curSum < target){
                do { left++ }while (left < right && nums[left] == nums[left-1])
            }else if(curSum > target){
                do { right-- }while (left < right && nums[right] == nums[right+1])
            }else{
                res.add(mutableListOf(nums[left],nums[right]))
                do { left++ }while (left < right && nums[left] == nums[left-1])
                do { right-- }while (left < right && nums[right] == nums[right+1])
            }
        }
        return res
    }

    fun threeSum(nums: IntArray): List<List<Int>>{
        nums.sort()
        val res = mutableListOf<List<Int>>()
        var i = 0
        while(i < nums.size){
            val twoSum =  - nums[i]
            val twoSumList = twoSum(nums, twoSum, i + 1)
            for (array in twoSumList){
                array.add(nums[i])
                res.add(array) 
            }
            while (i < nums.size && nums[i] == nums[i+1]) i++
            i++
        }
        return res
    }
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        //compute prefix sum
        val countMap = mutableMapOf<Int, Int>(0 to 1)
        var sum = 0
        var res = 0
        for( i in nums.indices){
            sum += nums[i]
            val remain = (sum+k) % k + k
            val old = countMap.getOrDefault(remain, 0)
            res += old
            countMap[remain] = old + 1
        }
        return res
    }
}

fun main() {

}