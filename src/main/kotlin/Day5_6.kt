class Day5_6 {

    fun removeElement(nums: IntArray, `val`: Int): Int {
        var fast = 0
        var slow = 0
        while(fast < nums.size) {
            if (nums[slow] == `val`){
                nums[slow] = nums[fast]
                slow++
            }
            fast++
        }
        return slow
    }
}