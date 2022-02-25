1.Two Sum

```kotlin
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
```

15. Three Sum 

```kotlin
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
```

3.Longest Substring Without Repeating Characters

```kotlin
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var left = 0
        var right = 0
        var maxLength = 0
        while (right < s.length){
            if (!set.contains(s[right])){
                set.add(s[right++])
                maxLength = kotlin.math.max(maxLength, set.size)
            }else{
                set.remove(s[left++])
            }
        }
        return maxLength
    }
}
```

