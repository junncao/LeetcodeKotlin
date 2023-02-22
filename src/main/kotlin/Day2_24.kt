
class Day2_24 {
    
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices){
            val anotherIndex = map[target - nums[i]]
            if (anotherIndex != null && anotherIndex!=i){
                return intArrayOf(anotherIndex, i)
            }else{
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }
// 三数之和：给一个Int的Array，返回里面之和为0的三个数。
// 先排序，然后先确定一个数a，然后找另外两个之和为-a的。双指针。注意为了避免有重复的，记得在指针移动的时候跳过值相同的数字。

    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0 until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            var j = i + 1
            var k = nums.size - 1
            val target = - nums[i]
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(listOf(nums[i], nums[j], nums[k]))
                    j++
                    k--
                    while (j < k && nums[j] == nums[j - 1]) j++ // skip same result, don't forget j < k
                    while (j < k && nums[k] == nums[k + 1]) k--
                }else if (nums[j] + nums[k] < target){
                    j++
                }else{
                    k--
                }
            }
        }
        return res
    }
}