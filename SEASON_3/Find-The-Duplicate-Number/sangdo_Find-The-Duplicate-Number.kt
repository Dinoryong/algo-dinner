class Solution {
    fun findDuplicate(nums: IntArray): Int {
        for(i in nums.indices) {
            var dest = i+1
            while(dest != nums[i]) {
                var to = nums[i]-1
                if(nums[to] == nums[i]) return nums[i]
                var t = nums[to]
                nums[to] = nums[i]
                nums[i] = t
            }
        }
        return nums.size+1
    }
}
