
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

    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()
        for (i in 0  until nums.size - 2) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
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
                    while (j < k && nums[j] == nums[j - 1]) j++ // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k-- // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--
                } else {
                    j++
                }
            }
        }
        return res
    }
}