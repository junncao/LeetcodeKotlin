import kotlin.math.abs
import kotlin.math.max

fun main(args: Array<String>) {
    val amountStr = "64.20"
    println((amountStr.toBigDecimal().setScale(2).toDouble() * 100).toLong())
//    println(lengthOfLongestSubstring("qweeewqweeeqweeeqwert"))
}
fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size
    while (start < end){
        val mid = (start + end) / 2
        if(target == nums[mid]){
            return mid
        }else if(target < nums[mid]){
            end = mid-1
        }else {
            start = mid
        }
    }
    return -1
}

fun sortedSquares(nums: IntArray): IntArray {
    return nums.sortedBy { abs(it) }.map { it * it }.toIntArray()
}
fun rotate(nums: IntArray, k: Int): Unit {
    fun reverse(nums: IntArray, start: Int, end: Int){
        var s = start
        var e = end
        while (s < e){
            val temp = nums[s]
            nums[s] = nums[e]
            nums[e] = temp
            s++
            e--
        }
    }
    val k = k % nums.size
    reverse(nums, 0, nums.size-1-k)
    reverse(nums, nums.size-k,nums.size-1)
    reverse(nums, 0, nums.size-1)

}
fun moveZeroes(nums: IntArray): Unit {
    var nonZeroIndex= 0
    var start = 0
    while (nonZeroIndex < nums.size && start < nums.size){
        if (nums[nonZeroIndex] == 0){
            nonZeroIndex ++
            continue
        }
        nums[start] = nums[nonZeroIndex]
        start ++
        nonZeroIndex ++
    }
    while (start < nums.size){
        nums[start] = 0
        start ++
    }
}

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.size - 1
    while(left < right){
        val sum = numbers[left] + numbers[right]
        if( sum == target){
            return intArrayOf(left + 1 ,right + 1)
        }else if(sum < target){
            left++
        }else{
            right--
        }
    }
    return intArrayOf()
}

fun lengthOfLongestSubstring(s: String): Int {
    val set = mutableSetOf<Char>()
    var left = 0
    var right = 0
    var maxLength = 0
    while (right < s.length){
        if (!set.contains(s[right])){
            set.add(s[right++])
            maxLength = max(maxLength, set.size)
        }else{
            set.remove(s[left++])
        }
    }
    return maxLength
}


