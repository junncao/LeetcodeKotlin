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
    fun searchLeftBound(nums: IntArray, target: Int): Int{
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
    fun searchRightBound(nums: IntArray, target: Int): Int{
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
}