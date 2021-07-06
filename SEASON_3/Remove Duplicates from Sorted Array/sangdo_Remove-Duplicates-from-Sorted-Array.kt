class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var prev = -1000
        var filled = 0
        for(i in nums.indices) {
            if(nums[i] != prev) {
                nums[filled] = nums[i]
                prev = nums[i]
                filled++
            }
        }
        return filled
    }
}
